package com.bbrakenhoff.adventofcode.day12

import kotlin.math.abs

abstract class Ship() {

    protected var northSouthPosition: Int = 0
    protected var eastWestPosition: Int = 0

    abstract fun navigateForward(units: Int)

    abstract fun navigateSouth(units: Int)

    abstract fun navigateNorth(units: Int)

    abstract fun navigateEast(units: Int)

    abstract fun navigateWest(units: Int)

    abstract fun rotateClockwise(units: Int)

    abstract fun rotateCounterclockwise(units: Int)

    protected fun countRotations(units: Int): Int = units / 90

    fun findManhattanDistance(): Int {
        return abs(eastWestPosition) + abs(northSouthPosition)
    }
}
