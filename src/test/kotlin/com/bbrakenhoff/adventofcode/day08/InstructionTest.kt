package com.bbrakenhoff.adventofcode.day08

import io.kotest.matchers.collections.shouldContainExactly
import org.junit.jupiter.api.Test

class InstructionTest {

    @Test
    fun `should parse instructions`() {
        val rawInstructions: List<String> = listOf("jmp +98", "acc +0", "nop +406", "acc +32", "acc -15", "jmp -68", "nop -86")
        val expectedInstructions: List<Instruction> =
            listOf(Instruction.Jump(98, true),
                   Instruction.Accumalator(0, true),
                   Instruction.NoOperation(406, true),
                   Instruction.Accumalator(32, true),
                   Instruction.Accumalator(15, false),
                   Instruction.Jump(68, false),
                   Instruction.NoOperation(86, false))

        val mappedInstructions: List<Instruction> = rawInstructions.map { Instruction.parseRaw(it) }
        mappedInstructions.shouldContainExactly(expectedInstructions)
    }
}