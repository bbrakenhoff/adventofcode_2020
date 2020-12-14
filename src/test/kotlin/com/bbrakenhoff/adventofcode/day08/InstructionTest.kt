package com.bbrakenhoff.adventofcode.day08

import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class InstructionTest {

    private fun testCalculateNewAccumulator(instruction: Instruction): Int = instruction.calculateNewAccumulator(ACCUMULATOR_VALUE)

    private fun testCalculateNextInstructionIndex(instruction: Instruction): Int = instruction.calculateNextInstructionIndex(NEXT_INSTRUCTION_INDEX)

    @Test
    fun `should parse instructions`() {
        val rawInstructions: List<String> = listOf("jmp +98", "acc +0", "nop +406", "acc +32", "acc -15", "jmp -68", "nop -86")
        val expectedInstructions: List<Instruction> =
            listOf(Instruction.Jump(98, true),
                   Instruction.Accumulator(0, true),
                   Instruction.NoOperation(406, true),
                   Instruction.Accumulator(32, true),
                   Instruction.Accumulator(15, false),
                   Instruction.Jump(68, false),
                   Instruction.NoOperation(86, false))

        val mappedInstructions: List<Instruction> = rawInstructions.map { Instruction.parseRaw(it) }
        mappedInstructions.shouldContainExactly(expectedInstructions)
    }

    @Test
    fun `should update execution times`() {
        val rawInstructions: List<String> = listOf("jmp +98", "acc +0", "nop +406")
        val mappedInstructions: List<Instruction> = rawInstructions.map { Instruction.parseRaw(it) }

        mappedInstructions.forEach {
            it.executedTimes shouldBe 0
            it.updateExecutionTimes()
            it.executedTimes shouldBe 1
        }
    }

    @Nested
    inner class Accumulator {

        @Test
        fun `should add amount to accumulator when increase is true`() {
            val instruction = Instruction.Accumulator(AMOUNT, true)
            testCalculateNewAccumulator(instruction) shouldBe ACCUMULATOR_VALUE + AMOUNT
        }

        @Test
        fun `should subtract amount from accumalator when increase is false`() {
            val instruction = Instruction.Accumulator(AMOUNT, false)
            testCalculateNewAccumulator(instruction) shouldBe ACCUMULATOR_VALUE - AMOUNT
        }

        @Test
        fun `should not do anything when already executed`() {
            val increaseAccumulatorInstruction: Instruction = Instruction.Accumulator(AMOUNT, true)

            testCalculateNewAccumulator(increaseAccumulatorInstruction) shouldBe ACCUMULATOR_VALUE + AMOUNT
            increaseAccumulatorInstruction.updateExecutionTimes()
            testCalculateNewAccumulator(increaseAccumulatorInstruction) shouldBe ACCUMULATOR_VALUE

            val decreaseAccumulatorInstruction: Instruction = Instruction.Accumulator(AMOUNT, false)
            testCalculateNewAccumulator(decreaseAccumulatorInstruction) shouldBe ACCUMULATOR_VALUE - AMOUNT
            decreaseAccumulatorInstruction.updateExecutionTimes()
            testCalculateNewAccumulator(decreaseAccumulatorInstruction) shouldBe ACCUMULATOR_VALUE
        }

        @Test
        fun `should increase next instruction index with 1`() {
            val instructions = listOf(Instruction.Accumulator(AMOUNT, true), Instruction.Accumulator(AMOUNT, false))

            instructions.forEach {
                testCalculateNextInstructionIndex(it) shouldBe ACCUMULATOR_VALUE + 1
            }
        }
    }

    @Nested
    inner class Jump {

        @Test
        fun `should not change value of accumulator`() {
            val instructions = listOf(Instruction.Jump(AMOUNT, true), Instruction.Jump(AMOUNT, false))

            instructions.forEach {
                testCalculateNewAccumulator(it) shouldBe ACCUMULATOR_VALUE
            }
        }

        @Test
        fun `should add amount to next instruction index when increase is true`() {
            val instruction = Instruction.Jump(AMOUNT, true)
            testCalculateNextInstructionIndex(instruction) shouldBe NEXT_INSTRUCTION_INDEX + AMOUNT
        }

        @Test
        fun `should subtract amount from next instruction index when increase is false`() {
            val instruction = Instruction.Jump(AMOUNT, false)
            testCalculateNextInstructionIndex(instruction) shouldBe NEXT_INSTRUCTION_INDEX - AMOUNT
        }
    }

    @Nested
    inner class NoOperation {
        @Test
        fun `should not change value of accumulator`() {
            val instructions = listOf(Instruction.NoOperation(AMOUNT, true), Instruction.NoOperation(AMOUNT, false))
            instructions.forEach {
                testCalculateNewAccumulator(it) shouldBe ACCUMULATOR_VALUE
            }
        }

        @Test
        fun `should increase next instruction index with 1`() {
            val instructions = listOf(Instruction.Accumulator(AMOUNT, true), Instruction.Accumulator(AMOUNT, false))

            instructions.forEach {
                testCalculateNextInstructionIndex(it) shouldBe ACCUMULATOR_VALUE + 1
            }
        }
    }

    companion object {
        private const val AMOUNT: Int = 3
        private const val ACCUMULATOR_VALUE: Int = 5
        private const val NEXT_INSTRUCTION_INDEX: Int = 5
    }
}
