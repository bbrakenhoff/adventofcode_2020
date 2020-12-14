package com.bbrakenhoff.adventofcode.day12

sealed class NavigationInstruction(open val units: Int, open val ship: Ship) {

    abstract fun navigateShip()

    data class Forward(override val units: Int, override val ship: Ship) : NavigationInstruction(units, ship) {

        override fun navigateShip() {
            ship.navigateForward(units)
        }
    }

    data class North(override val units: Int, override val ship: Ship) : NavigationInstruction(units, ship) {

        override fun navigateShip() {
            ship.navigateNorth(units)
        }
    }

    data class East(override val units: Int, override val ship: Ship) : NavigationInstruction(units, ship) {

        override fun navigateShip() {
            ship.navigateEast(units)
        }
    }

    data class South(override val units: Int, override val ship: Ship) : NavigationInstruction(units, ship) {

        override fun navigateShip() {
            ship.navigateSouth(units)
        }
    }

    data class West(override val units: Int, override val ship: Ship) : NavigationInstruction(units, ship) {

        override fun navigateShip() {
            ship.navigateWest(units)
        }
    }

    data class RotateCounterclockwise(override val units: Int, override val ship: Ship) : NavigationInstruction(units, ship) {

        override fun navigateShip() {
            ship.rotateCounterclockwise(units)
        }
    }

    data class RotateClockwise(override val units: Int, override val ship: Ship) : NavigationInstruction(units, ship) {

        override fun navigateShip() {
            ship.rotateClockwise(units)
        }
    }

    companion object {
        fun createFromInstructionLine(instructionLine: String, ship: Ship): NavigationInstruction {
            val instructionIdentifier: Char = instructionLine[0]
            val units: Int = instructionLine.substring(1).toInt()
            return when (instructionIdentifier) {
                'N' -> North(units, ship)
                'S' -> South(units, ship)
                'E' -> East(units, ship)
                'W' -> West(units, ship)
                'F' -> Forward(units, ship)
                'L' -> RotateCounterclockwise(units, ship)
                'R' -> RotateClockwise(units, ship)
                else -> throw IllegalArgumentException("Unknown instruction identifier: $instructionIdentifier")
            }
        }
    }
}
