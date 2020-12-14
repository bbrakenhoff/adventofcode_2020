package com.bbrakenhoff.adventofcode.day12

class NormalShip : Ship() {

    private var facingDirection: Compass = Compass.EAST

    override fun navigateNorth(units: Int) {
        northSouthPosition -= units
    }

    override fun navigateSouth(units: Int) {
        northSouthPosition += units
    }

    override fun navigateEast(units: Int) {
        eastWestPosition += units
    }

    override fun navigateWest(units: Int) {
        eastWestPosition -= units
    }

    override fun navigateForward(units: Int) {
        forwardMovementToCompassDirection(units).navigateShip()
    }

    private fun forwardMovementToCompassDirection(units: Int): NavigationInstruction {
        return when (facingDirection) {
            Compass.NORTH -> NavigationInstruction.North(units, this)
            Compass.EAST -> NavigationInstruction.East(units, this)
            Compass.SOUTH -> NavigationInstruction.South(units, this)
            Compass.WEST -> NavigationInstruction.West(units, this)
        }
    }

    override fun rotateClockwise(units: Int) {
        repeat(countRotations(units)) {
            facingDirection = facingDirection.rotateClockwise()
        }
    }

    override fun rotateCounterclockwise(units: Int) {
        repeat(countRotations(units)) {
            facingDirection = facingDirection.rotateCounterClockwise()
        }
    }
}
