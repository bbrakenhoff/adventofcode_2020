package com.bbrakenhoff.adventofcode.day08

import com.bbrakenhoff.adventofcode.Day
import com.bbrakenhoff.adventofcode.PuzzleInputReader

class Day08 : Day {

    override val enabledFocusedPrint: Boolean = true

    private val rawInstructions: List<String> = PuzzleInputReader.read(8)
    private val gameConsole: GameConsole = GameConsole(rawInstructions)

    override fun partOne(): String {
        gameConsole.boot()

        return "${gameConsole.accumulator}"
    }

    override fun partTwo(): String {
        return ""
    }
}