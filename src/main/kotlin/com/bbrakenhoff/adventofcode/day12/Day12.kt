package com.bbrakenhoff.adventofcode.day12

import com.bbrakenhoff.adventofcode.Day
import com.bbrakenhoff.adventofcode.PuzzleInputReader
import kotlin.math.abs

class Day12 : Day {
    override val enabledFocusedPrint: Boolean = true

//    private val directions: List<String> = listOf("F10", "N3", "F7", "R90", "F11")
    private val directions: List<String> = PuzzleInputReader.read(12)


    override fun partOne(): String {
        var facing = Direction.EAST
        var horizontalPos = 0
        var verticalPos = 0

        directions.forEach {
            var instruction = it[0]
            val units = it.substring(1).toInt()

            if (instruction == 'F') {
                instruction = when (facing) {
                    Direction.NORTH -> 'N'
                    Direction.EAST -> 'E'
                    Direction.SOUTH -> 'S'
                    Direction.WEST -> 'W'
                }
            }

            when (instruction) {
                'S' -> {
                    verticalPos += units
                }
                'N' -> {
                    verticalPos -= units
                }
                'E' -> {
                    horizontalPos += units
                }
                'W' -> {
                    horizontalPos -= units
                }
                'R' -> {
                    val rotations = units / 90
                    repeat(rotations) {
                        facing = facing.clockwise()
                    }
                }
                'L' -> {
                    val rotations = units / 90
                    repeat(rotations) {
                        facing = facing.counterClockwise()
                    }
                }
            }
        }

        val result = abs(horizontalPos) + abs(verticalPos)
        return "$result"
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
                    horizontalWaypoint = -verticalWaypoint.also { verticalWaypoint = horizontalWaypoint }
                }
                'R' -> repeat(units / 90) {
                    verticalWaypoint = -horizontalWaypoint.also { horizontalWaypoint = verticalWaypoint }
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
