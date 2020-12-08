package com.bbrakenhoff.adventofcode.day08

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class GameConsoleTest {

    @Test
    fun `accumalator should initially be 0`() {
        val gameConsole: GameConsole = GameConsole(RAW_INSTRUCTIONS)
        gameConsole.accumulator shouldBe 0
    }

    @Test
    fun `should return the value of accumulator when instruction reached second time`() {
        val gameConsole: GameConsole = GameConsole(RAW_INSTRUCTIONS)
        gameConsole.boot()
        gameConsole.accumulator shouldBe 5
    }

    @Test
    fun `should return the value of accumulator when boot completed`() {
        val gameConsole: GameConsole = GameConsole(RAW_INSTRUCTIONS)
        gameConsole.fixedBoot()
        gameConsole.accumulator shouldBe 8
    }

    companion object {
        private val RAW_INSTRUCTIONS: List<String> = listOf("nop +0", "acc +1", "jmp +4", "acc +3", "jmp -3", "acc -99", "acc +1", "jmp -4", "acc +6")
    }
}