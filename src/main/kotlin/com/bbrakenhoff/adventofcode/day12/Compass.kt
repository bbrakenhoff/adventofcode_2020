package com.bbrakenhoff.adventofcode.day12

enum class Compass {
    NORTH, EAST, SOUTH, WEST;

    fun rotateClockwise(): Compass = when (this) {
        NORTH -> EAST
        EAST -> SOUTH
        SOUTH -> WEST
        WEST -> NORTH
    }

    fun rotateCounterClockwise(): Compass = when (this) {
        NORTH -> WEST
        WEST -> SOUTH
        SOUTH -> EAST
        EAST -> NORTH
    }
}
