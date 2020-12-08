package com.bbrakenhoff.adventofcode.day08

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class GameConsoleInfiniteBootLoopTest {
    @Test
    fun `accumalator should initially be 0`() {
        val gameConsoleOld: GameConsole = GameConsoleInfiniteBootLoop(RAW_INSTRUCTIONS)
        gameConsoleOld.accumulator shouldBe 0
    }

    @Test
    fun `should return the value of accumulator when instruction reached second time`() {
        val gameConsoleOld: GameConsole = GameConsoleInfiniteBootLoop(RAW_INSTRUCTIONS)
        gameConsoleOld.boot()
        gameConsoleOld.accumulator shouldBe 5
    }

    companion object {
        private val RAW_INSTRUCTIONS: List<String> = listOf("nop +0", "acc +1", "jmp +4", "acc +3", "jmp -3", "acc -99", "acc +1", "jmp -4", "acc +6")
    }
}
