package com.bbrakenhoff.adventofcode.day12

import com.bbrakenhoff.adventofcode.Day
import com.bbrakenhoff.adventofcode.PuzzleInputReader

class Day12 : Day {

    override val enabledFocusedPrint: Boolean = true

    private val navigationInstructions: List<NavigationInstruction> =
        PuzzleInputReader.read(12)
            .map { NavigationInstruction.createFromInstructionLine(it) }
    
    override fun partOne(): String {
        val ship: Ship = NormalShip(navigationInstructions)
        return getManhattanDistanceFromShip(ship)
    }

    private fun getManhattanDistanceFromShip(ship: Ship): String =
        "${ship.navigateAndFindManhattanDistance()}"

    override fun partTwo(): String {
        val ship: Ship = ShipWithWaypoint(navigationInstructions)
        return getManhattanDistanceFromShip(ship)
    }
}
