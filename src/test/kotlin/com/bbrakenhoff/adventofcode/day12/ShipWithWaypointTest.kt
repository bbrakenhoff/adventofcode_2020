package com.bbrakenhoff.adventofcode.day12

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class ShipWithWaypointTest {

    @Test
    fun `should find distance between starting position and destination`() {
        val shipWithWaypoint: ShipWithWaypoint =
            ShipWithWaypoint(NAVIGATION_INSTRUCTIONS)

        shipWithWaypoint.navigateAndFindManhattanDistance() shouldBe 286
    }

    companion object {
        private val NAVIGATION_INSTRUCTIONS: List<NavigationInstruction> =
            listOf("F10", "N3", "F7", "R90", "F11").map {
                NavigationInstruction.createFromInstructionLine(it)
            }
    }
}
