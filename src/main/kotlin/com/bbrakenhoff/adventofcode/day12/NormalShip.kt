package com.bbrakenhoff.adventofcode.day12

class NormalShip(navigationInstructions: List<NavigationInstruction>):Ship(navigationInstructions) {

    private var facingDirection: Compass = Compass.EAST

    override fun navigate() {
        navigationInstructions.forEach {
            var instruction: NavigationInstruction = it
            if (instruction is NavigationInstruction.Forward) {
                instruction = forwardMovementToCompassDirection(instruction)
            }

            processInstruction(instruction)
        }
    }

    private fun processInstruction(instruction: NavigationInstruction) {
        when (instruction) {
            is NavigationInstruction.South -> northSouthPosition += instruction.units
            is NavigationInstruction.North -> northSouthPosition -= instruction.units
            is NavigationInstruction.East -> eastWestPosition += instruction.units
            is NavigationInstruction.West -> eastWestPosition -= instruction.units
            is NavigationInstruction.RotateRight -> {
                repeat(countRotations(instruction.units)) {
                    facingDirection = facingDirection.rotateClockwise()
                }
            }
            is NavigationInstruction.RotateLeft -> {
                repeat(countRotations(instruction.units)) {
                    facingDirection =
                        facingDirection.rotateCounterClockwise()
                }
            }
            else -> {
            }
        }
    }

    private fun forwardMovementToCompassDirection(forwardNavigationInstruction: NavigationInstruction.Forward): NavigationInstruction {
        return when (facingDirection) {
            Compass.NORTH -> NavigationInstruction.North(
                forwardNavigationInstruction.units
            )
            Compass.EAST -> NavigationInstruction.East(forwardNavigationInstruction.units)
            Compass.SOUTH -> NavigationInstruction.South(
                forwardNavigationInstruction.units
            )
            Compass.WEST -> NavigationInstruction.West(forwardNavigationInstruction.units)
        }
    }
}
