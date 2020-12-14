package com.bbrakenhoff.adventofcode.day12

import com.bbrakenhoff.adventofcode.Day
import com.bbrakenhoff.adventofcode.PuzzleInputReader

class Day12 : Day {

    override val enabledFocusedPrint: Boolean = true

    private val navigationInstructions: List<String> = PuzzleInputReader.read(12)

    override fun partOne(): String {
        val ship: Ship = NormalShip()
        return navigateAndFindManhattanDistance(ship)
    }

    private fun navigateAndFindManhattanDistance(ship: Ship): String {
        navigationInstructions.map { NavigationInstruction.createFromInstructionLine(it, ship) }.forEach {
            it.navigateShip()
        }
        return "${ship.findManhattanDistance()}"
    }

    override fun partTwo(): String {
        val ship: Ship = ShipWithWaypoint()
        return navigateAndFindManhattanDistance(ship)
    }
}
