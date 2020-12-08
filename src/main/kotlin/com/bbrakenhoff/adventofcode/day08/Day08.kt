package com.bbrakenhoff.adventofcode.day08

import com.bbrakenhoff.adventofcode.Day
import com.bbrakenhoff.adventofcode.PuzzleInputReader

class Day08 : Day {

    override val enabledFocusedPrint: Boolean = true

    private val rawInstructions: List<String> = PuzzleInputReader.read(8)

    override fun partOne(): String {
        val gameConsole: GameConsole = GameConsole(rawInstructions)
        gameConsole.boot()

        return "${gameConsole.accumulator}"
    }

    override fun partTwo(): String {
        val gameConsole: GameConsole = GameConsole(rawInstructions)
        gameConsole.fixedBoot()
        println("is boot complete? ${gameConsole.isBootComplete()}")
        return "${gameConsole.accumulator}"
    }
}