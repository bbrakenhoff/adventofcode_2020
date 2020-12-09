package com.bbrakenhoff.adventofcode.day08

import com.bbrakenhoff.adventofcode.Day
import com.bbrakenhoff.adventofcode.PuzzleInputReader

class Day08 : Day {

    override val enabledFocusedPrint: Boolean = false

    private val rawInstructions: List<String> = PuzzleInputReader.read(8)

    private lateinit var gameConsole: GameConsole

    override fun partOne(): String {
        gameConsole = GameConsoleInfiniteBootLoop(rawInstructions)
        return getAccumulator()
    }

    private fun getAccumulator(): String {
        gameConsole.boot()
        val accumulator = gameConsole.accumulator
        return "$accumulator"
    }

    override fun partTwo(): String {
        gameConsole = GameConsoleFixed(rawInstructions)
        return getAccumulator()
    }
}
