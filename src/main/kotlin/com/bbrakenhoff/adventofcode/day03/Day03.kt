package com.bbrakenhoff.adventofcode.day03

import com.bbrakenhoff.adventofcode.Day
import com.bbrakenhoff.adventofcode.PuzzleInputReader

class Day03() : Day {

    override val enabledFocusedPrint: Boolean = true

    private val map: List<String> = PuzzleInputReader.read(3)

    override fun partOne(): String {
        val mapInitialWidth: Int = map.first().length
        var currentPositionX: Int = 0
        var treeCount = 0

        for (currentPositionY: Int in map.indices) {
            val xInLine: Int = currentPositionX % mapInitialWidth
            val charAtCurrPos: Char = map[currentPositionY][xInLine]

            if (charRepresentsTree(charAtCurrPos)) {
                treeCount++
            }

            println("xInLine: $xInLine, currPosX: $currentPositionX, charAt currPos: $charAtCurrPos, treeCount $treeCount")
            currentPositionX += 3
        }

        return "$treeCount"
    }

    private fun charRepresentsTree(charAtCurrentPosition: Char) = charAtCurrentPosition == '#'

    override fun partTwo(): String { //        TODO("Not yet implemented")
        return ""
    }
}