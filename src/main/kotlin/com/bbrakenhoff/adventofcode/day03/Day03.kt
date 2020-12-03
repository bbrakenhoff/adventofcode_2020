package com.bbrakenhoff.adventofcode.day03

import com.bbrakenhoff.adventofcode.Day
import com.bbrakenhoff.adventofcode.PuzzleInputReader

class Day03() : Day {

    override val enabledFocusedPrint: Boolean = true

    private val map: List<String> = PuzzleInputReader.read(3)

    override fun partOne(): String {
        val treeCount = Slope().countTreesInSlope()
        return "$treeCount"
    }

    override fun partTwo(): String { //        TODO("Not yet implemented")
        return ""
    }
}