package com.bbrakenhoff.adventofcode.day10

import com.bbrakenhoff.adventofcode.Day
import com.bbrakenhoff.adventofcode.PuzzleInputReader

class Day10 : Day {

    override val enabledFocusedPrint: Boolean = true

    private val outputJoltage: List<Int> = PuzzleInputReader.read(10).map { it.toInt() }

    override fun partOne(): String {
        val adapters = JoltageAdapterFinder(outputJoltage)
        adapters.find()
        val differenceBy1 = adapters.differences1Jolt
        val differenceBy3 = adapters.differences3Jolt
        val multiply = differenceBy1 * differenceBy3

        return "$multiply"
    }

    override fun partTwo(): String {
        val adapters = JoltageAdapterFinder(outputJoltage)
        val arrangements = adapters.findPermutationCount()
        return "$arrangements"
    }
}