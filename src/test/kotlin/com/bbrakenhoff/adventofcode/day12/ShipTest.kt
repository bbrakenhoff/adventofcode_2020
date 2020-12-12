package com.bbrakenhoff.adventofcode.day12

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class ShipTest {

    @Test
    fun `should find distance between starting position and destination`() {
        val ship: Ship = Ship(MOVEMENT_INSTRUCTIONS)
        ship.findManhattanDistance() shouldBe 25
    }

    companion object {
        private val MOVEMENT_INSTRUCTIONS: List<MovementInstruction> =
            listOf("F10", "N3", "F7", "R90", "F11").map {
                MovementInstruction.createFromInstructionLine(it)
            }
    }
}
