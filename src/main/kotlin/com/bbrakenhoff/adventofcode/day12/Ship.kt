package com.bbrakenhoff.adventofcode.day12

import kotlin.math.abs

class Ship(private val movementInstructions: List<MovementInstruction>) {

    private var facingDirection: Compass = Compass.EAST
    private var northSouthPosition: Int = 0
    private var eastWestPosition: Int = 0


    fun findManhattanDistance(): Int {
        processMovementInstructions()

        return abs(eastWestPosition) + abs(northSouthPosition)
    }

    private fun processMovementInstructions() {
        movementInstructions.forEach {
            var instruction: MovementInstruction = it
            if (instruction is MovementInstruction.Forward) {
                instruction = forwardMovementToCompassDirection(instruction)
            }

            processInstruction(instruction)
        }
    }

    private fun processInstruction(instruction: MovementInstruction) {
        when (instruction) {
            is MovementInstruction.South -> northSouthPosition += instruction.units
            is MovementInstruction.North -> northSouthPosition -= instruction.units
            is MovementInstruction.East -> eastWestPosition += instruction.units
            is MovementInstruction.West -> eastWestPosition -= instruction.units
            is MovementInstruction.RotateRight -> {
                repeat(countRotations(instruction.units)) {
                    facingDirection = facingDirection.rotateClockwise()
                }
            }
            is MovementInstruction.RotateLeft -> {
                repeat(countRotations(instruction.units)) {
                    facingDirection =
                        facingDirection.rotateCounterClockwise()
                }
            }
            else -> {
            }
        }
    }

    private fun forwardMovementToCompassDirection(forwardMovementInstruction: MovementInstruction.Forward): MovementInstruction {
        return when (facingDirection) {
            Compass.NORTH -> MovementInstruction.North(
                forwardMovementInstruction.units
            )
            Compass.EAST -> MovementInstruction.East(forwardMovementInstruction.units)
            Compass.SOUTH -> MovementInstruction.South(
                forwardMovementInstruction.units
            )
            Compass.WEST -> MovementInstruction.West(forwardMovementInstruction.units)
        }
    }

    private fun countRotations(units: Int): Int = units / 90
}
