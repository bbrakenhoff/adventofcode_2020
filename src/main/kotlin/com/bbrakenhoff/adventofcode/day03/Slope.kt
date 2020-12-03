package com.bbrakenhoff.adventofcode.day03

import com.bbrakenhoff.adventofcode.PuzzleInputReader

class Slope(private val horizontalSteps: Int, private val verticalSteps: Int) {

    fun countTreesInSlope(): Long {
        val mapInitialWidth: Int = SLOPE_MAP.first().length
        var currentPositionX: Int = 0

        val passedLinesOnMap: List<String> = SLOPE_MAP.filterIndexed { currentPositionY: Int, _ -> currentPositionY % verticalSteps == 0 }
        val squaresPassed: List<Char> = passedLinesOnMap.map { line: String ->
            val xInLine: Int = currentPositionX % mapInitialWidth
            val squarePassed: Char = line[xInLine]
            currentPositionX += horizontalSteps

            squarePassed
        }
        val treesPassed: List<Char> = squaresPassed.filter { charRepresentsTree(it) }
        return treesPassed.size.toLong()
    }

    private fun charRepresentsTree(charAtCurrentPosition: Char): Boolean = charAtCurrentPosition == '#'

    companion object {
        private val SLOPE_MAP: List<String> = PuzzleInputReader.read(3)
    }
}