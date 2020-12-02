package com.bbrakenhoff.adventofcode.day02

import com.bbrakenhoff.adventofcode.Day
import com.bbrakenhoff.adventofcode.PuzzleInputReader

class Day02 : Day {

    override val enabledFocusedPrint: Boolean = true

    override fun partOne(): String {
        return readPuzzleInput().toString()
    }

    override fun partTwo(): String {
        return ""
    }

    private fun readPuzzleInput(): Map<PasswordPolicy, String> {
        val puzzleInputReader = PuzzleInputReader.read(2)
        return puzzleInputReader.associate {
            val splitLine = it.split(':')
            val policy: String = splitLine.first().trim()
            val password: String = splitLine.last().trim()

            Pair(PasswordPolicy.createFromPuzzleInput(policy), password)
        }
    }
}