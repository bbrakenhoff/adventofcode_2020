package com.bbrakenhoff.adventofcode.day03

class Slope(private val slopeMap: List<String>, private val horizontalSteps: Int, private val verticalSteps: Int) {

    fun countTreesInSlope(): Long {
        val mapInitialWidth: Int = slopeMap.first().length
        var currentPositionX: Int = 0

        val passedLinesOnMap: List<String> = slopeMap.filterIndexed { currentPositionY: Int, _ -> currentPositionY % verticalSteps == 0 }
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
}
