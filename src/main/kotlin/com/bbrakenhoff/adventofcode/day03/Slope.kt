package com.bbrakenhoff.adventofcode.day03

import com.bbrakenhoff.adventofcode.PuzzleInputReader

class Slope(private val verticalSteps: Int = 1, private val horizontalSteps: Int = 3) {

    private val slopeMap = PuzzleInputReader.read(3)

    fun countTreesInSlope(): Long {
        val mapInitialWidth: Int = slopeMap.first().length
        var currentPositionX: Int = 0
        var treeCount: Long = 0L

        for (currentPositionY: Int in slopeMap.indices) {
            val xInLine: Int = currentPositionX % mapInitialWidth
            val charAtCurrPos: Char = slopeMap[currentPositionY][xInLine]

            if (charRepresentsTree(charAtCurrPos)) {
                treeCount++
            }

            println("xInLine: $xInLine, currPosX: $currentPositionX, charAt currPos: $charAtCurrPos, treeCount $treeCount")
            currentPositionX += 3
        }

        return treeCount
    }

    private fun charRepresentsTree(charAtCurrentPosition: Char): Boolean = charAtCurrentPosition == '#'

}