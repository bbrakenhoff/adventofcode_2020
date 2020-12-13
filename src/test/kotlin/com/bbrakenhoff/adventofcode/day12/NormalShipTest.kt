package com.bbrakenhoff.adventofcode.day12

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class NormalShipTest {

    @Test
    fun `should find distance between starting position and destination`() {
        val ship: NormalShip = NormalShip(NAVIGATION_INSTRUCTIONS)
        ship.navigateAndFindManhattanDistance() shouldBe 25
    }

    companion object {
        private val NAVIGATION_INSTRUCTIONS: List<NavigationInstruction> =
            listOf("F10", "N3", "F7", "R90", "F11").map {
                NavigationInstruction.createFromInstructionLine(it)
            }
    }
}
