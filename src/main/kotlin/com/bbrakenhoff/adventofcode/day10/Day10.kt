package com.bbrakenhoff.adventofcode.day10

import com.bbrakenhoff.adventofcode.Day
import com.bbrakenhoff.adventofcode.PuzzleInputReader

class Day10 : Day {

    override val enabledFocusedPrint: Boolean = false

    private val outputJoltage: List<Int> = PuzzleInputReader.read(10).map { it.toInt() }
    private val joltageAdapters = JoltageAdapters(outputJoltage)

    override fun partOne(): String {
        val joltDifferences: JoltRatingCount = joltageAdapters.findJoltRatings()
        val multipliedJoltDifferences: Int = joltDifferences.joltage1 * joltDifferences.joltage3
        return "$multipliedJoltDifferences"
    }

    override fun partTwo(): String {
        return "${joltageAdapters.findPossibleAdapterArrangments()}"
    }
}
