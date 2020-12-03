package com.bbrakenhoff.adventofcode.day03

import com.bbrakenhoff.adventofcode.PuzzleInputReader

class Slope(private val horizontalSteps: Int, private val verticalSteps: Int) {

    fun countTreesInSlope(): Long {
        val mapInitialWidth: Int = SLOPE_MAP.first().length
        var currentPositionX: Int = 0
        var treeCount: Long = 0L

        for (currentPositionY: Int in SLOPE_MAP.indices) {

            if (currentPositionY % verticalSteps == 0) {

                val xInLine: Int = currentPositionX % mapInitialWidth
                val charAtCurrPos: Char = SLOPE_MAP[currentPositionY][xInLine]

                if (charRepresentsTree(charAtCurrPos)) {
                    treeCount++
                }

//                println("xInLine: $xInLine, currPosX: $currentPositionX, charAt currPos: $charAtCurrPos, treeCount $treeCount")
                currentPositionX += horizontalSteps
            }
        }

        return treeCount
    }

    private fun charRepresentsTree(charAtCurrentPosition: Char): Boolean = charAtCurrentPosition == '#'

    companion object {
        private val SLOPE_MAP: List<String> = PuzzleInputReader.read(3)
    }
}