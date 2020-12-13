package com.bbrakenhoff.adventofcode.day12

import kotlin.math.abs

abstract class Ship(protected val navigationInstructions: List<NavigationInstruction>) {

    protected var northSouthPosition: Int = 0
    protected var eastWestPosition: Int = 0

    fun navigateAndFindManhattanDistance(): Int {
        navigate()
        return abs(eastWestPosition) + abs(northSouthPosition)
    }

    protected abstract fun navigate()

    protected fun countRotations(units: Int): Int = units / 90
}
