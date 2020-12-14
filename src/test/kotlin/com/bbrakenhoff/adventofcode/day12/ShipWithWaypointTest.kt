package com.bbrakenhoff.adventofcode.day12

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ShipWithWaypointTest {

    private lateinit var ship: ShipWithWaypoint
    private lateinit var navigationInstructions: List<NavigationInstruction>

    @BeforeEach
    fun beforeEach() {
        ship = ShipWithWaypoint()
        navigationInstructions = NAVIGATION_INSTRUCTIONS.map { NavigationInstruction.createFromInstructionLine(it, ship) }
    }

    private fun testFindingManhattanDistance(): Int {
        navigationInstructions.forEach { it.navigateShip() }
        return ship.findManhattanDistance()
    }

    @Test
    fun `should find manhattan distance the ship has navigated`() {
        testFindingManhattanDistance() shouldBe 405
    }

    companion object {
        private val NAVIGATION_INSTRUCTIONS: List<String> = listOf("F10", "N3", "F7", "R90", "F11", "E3", "F7", "L90", "E2", "S4", "W6")
    }
}
