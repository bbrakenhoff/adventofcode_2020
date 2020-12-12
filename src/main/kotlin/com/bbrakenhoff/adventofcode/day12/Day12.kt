package com.bbrakenhoff.adventofcode.day12

import com.bbrakenhoff.adventofcode.Day
import com.bbrakenhoff.adventofcode.PuzzleInputReader
import kotlin.math.abs

class Day12 : Day {

    override val enabledFocusedPrint: Boolean = true

    private val movementInstructions: List<MovementInstruction> =
        PuzzleInputReader.read(12)
            .map { MovementInstruction.createFromInstructionLine(it) }


    private val directions: List<String> = PuzzleInputReader.read(12)

    override fun partOne(): String {
        val ship: Ship = Ship(movementInstructions)
        return "${ship.findManhattanDistance()}"
    }

    override fun partTwo(): String {
        var horizontalPos = 0
        var verticalPos = 0
        var horizontalWaypoint = 10
        var verticalWaypoint = 1

        directions.forEach {
            val instruction = it[0]
            val units = it.substring(1).toInt()

            when (instruction) {
                'N' -> verticalWaypoint += units
                'S' -> verticalWaypoint -= units
                'E' -> horizontalWaypoint += units
                'W' -> horizontalWaypoint -= units
                'L' -> repeat(units / 90) {
                    horizontalWaypoint = -verticalWaypoint.also {
                        verticalWaypoint = horizontalWaypoint
                    }
                }
                'R' -> repeat(units / 90) {
                    verticalWaypoint = -horizontalWaypoint.also {
                        horizontalWaypoint = verticalWaypoint
                    }
                }
                'F' -> {
                    verticalPos += verticalWaypoint * units
                    horizontalPos += horizontalWaypoint * units
                }
            }
        }

        val result = abs(horizontalPos) + abs(verticalPos)
        return "$result"
    }

    enum class Direction {
        NORTH, EAST, SOUTH, WEST;

        fun clockwise(): Direction = when (this) {
            NORTH -> EAST
            EAST -> SOUTH
            SOUTH -> WEST
            WEST -> NORTH
        }

        fun counterClockwise(): Direction = when (this) {
            NORTH -> WEST
            WEST -> SOUTH
            SOUTH -> EAST
            EAST -> NORTH
        }
    }
}
