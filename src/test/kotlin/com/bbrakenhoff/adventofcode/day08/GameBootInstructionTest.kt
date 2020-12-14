package com.bbrakenhoff.adventofcode.day08

import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class GameBootInstructionTest {

    private fun testCalculateNewAccumulator(instruction: GameBootInstruction): Int = instruction.calculateNewAccumulator(ACCUMULATOR_VALUE)

    private fun testCalculateNextInstructionIndex(instruction: GameBootInstruction): Int = instruction.calculateNextInstructionIndex(NEXT_INSTRUCTION_INDEX)

    @Test
    fun `should parse instructions`() {
        val rawInstructions: List<String> = listOf("jmp +98", "acc +0", "nop +406", "acc +32", "acc -15", "jmp -68", "nop -86")
        val expectedInstructions: List<GameBootInstruction> =
            listOf(GameBootInstruction.Jump(98, true),
                   GameBootInstruction.Accumulator(0, true),
                   GameBootInstruction.NoOperation(406, true),
                   GameBootInstruction.Accumulator(32, true),
                   GameBootInstruction.Accumulator(15, false),
                   GameBootInstruction.Jump(68, false),
                   GameBootInstruction.NoOperation(86, false))

        val mappedInstructions: List<GameBootInstruction> = rawInstructions.map { GameBootInstruction.parseRaw(it) }
        mappedInstructions.shouldContainExactly(expectedInstructions)
    }

    @Test
    fun `should update execution times`() {
        val rawInstructions: List<String> = listOf("jmp +98", "acc +0", "nop +406")
        val mappedInstructions: List<GameBootInstruction> = rawInstructions.map { GameBootInstruction.parseRaw(it) }

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
            val instruction = GameBootInstruction.Accumulator(AMOUNT, true)
            testCalculateNewAccumulator(instruction) shouldBe ACCUMULATOR_VALUE + AMOUNT
        }

        @Test
        fun `should subtract amount from accumalator when increase is false`() {
            val instruction = GameBootInstruction.Accumulator(AMOUNT, false)
            testCalculateNewAccumulator(instruction) shouldBe ACCUMULATOR_VALUE - AMOUNT
        }

        @Test
        fun `should not do anything when already executed`() {
            val increaseAccumulatorInstruction: GameBootInstruction = GameBootInstruction.Accumulator(AMOUNT, true)

            testCalculateNewAccumulator(increaseAccumulatorInstruction) shouldBe ACCUMULATOR_VALUE + AMOUNT
            increaseAccumulatorInstruction.updateExecutionTimes()
            testCalculateNewAccumulator(increaseAccumulatorInstruction) shouldBe ACCUMULATOR_VALUE

            val decreaseAccumulatorInstruction: GameBootInstruction = GameBootInstruction.Accumulator(AMOUNT, false)
            testCalculateNewAccumulator(decreaseAccumulatorInstruction) shouldBe ACCUMULATOR_VALUE - AMOUNT
            decreaseAccumulatorInstruction.updateExecutionTimes()
            testCalculateNewAccumulator(decreaseAccumulatorInstruction) shouldBe ACCUMULATOR_VALUE
        }

        @Test
        fun `should increase next instruction index with 1`() {
            val instructions = listOf(GameBootInstruction.Accumulator(AMOUNT, true), GameBootInstruction.Accumulator(AMOUNT, false))

            instructions.forEach {
                testCalculateNextInstructionIndex(it) shouldBe ACCUMULATOR_VALUE + 1
            }
        }
    }

    @Nested
    inner class Jump {

        @Test
        fun `should not change value of accumulator`() {
            val instructions = listOf(GameBootInstruction.Jump(AMOUNT, true), GameBootInstruction.Jump(AMOUNT, false))

            instructions.forEach {
                testCalculateNewAccumulator(it) shouldBe ACCUMULATOR_VALUE
            }
        }

        @Test
        fun `should add amount to next instruction index when increase is true`() {
            val instruction = GameBootInstruction.Jump(AMOUNT, true)
            testCalculateNextInstructionIndex(instruction) shouldBe NEXT_INSTRUCTION_INDEX + AMOUNT
        }

        @Test
        fun `should subtract amount from next instruction index when increase is false`() {
            val instruction = GameBootInstruction.Jump(AMOUNT, false)
            testCalculateNextInstructionIndex(instruction) shouldBe NEXT_INSTRUCTION_INDEX - AMOUNT
        }
    }

    @Nested
    inner class NoOperation {
        @Test
        fun `should not change value of accumulator`() {
            val instructions = listOf(GameBootInstruction.NoOperation(AMOUNT, true), GameBootInstruction.NoOperation(AMOUNT, false))
            instructions.forEach {
                testCalculateNewAccumulator(it) shouldBe ACCUMULATOR_VALUE
            }
        }

        @Test
        fun `should increase next instruction index with 1`() {
            val instructions = listOf(GameBootInstruction.Accumulator(AMOUNT, true), GameBootInstruction.Accumulator(AMOUNT, false))

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
