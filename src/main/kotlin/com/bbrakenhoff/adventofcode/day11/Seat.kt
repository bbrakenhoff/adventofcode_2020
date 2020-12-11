package com.bbrakenhoff.adventofcode.day11

data class Seat(val position: Pair<Int, Int>, private var _char: Char) {

    val char: Char
        get() = _char

    private val isSeat: Boolean
        get() = _char == EMPTY_SEAT || _char == OCCUPIED_SEAT
    val isFloor: Boolean = !isSeat

    val isOccupied: Boolean
        get() = _char == OCCUPIED_SEAT

    fun positionTop(): Pair<Int, Int> = position.first to position.second - 1

    fun positionBottom(): Pair<Int, Int> = position.first to position.second + 1

    fun positionLeft(): Pair<Int, Int> = position.first - 1 to position.second

    fun positionRight(): Pair<Int, Int> = position.first + 1 to position.second

    fun positionLeftTop(): Pair<Int, Int> = position.first - 1 to position.second - 1

    fun positionRightTop(): Pair<Int, Int> = position.first + 1 to position.second - 1

    fun positionRightBottom(): Pair<Int, Int> = position.first + 1 to position.second + 1

    fun positionLeftBottom(): Pair<Int, Int> = position.first - 1 to position.second + 1

    fun clear() {
        if (!isFloor) {
            _char = EMPTY_SEAT
        }
    }

    fun occupy() {
        if (!isFloor) {
            _char = OCCUPIED_SEAT
        }
    }

    companion object {
        private const val EMPTY_SEAT: Char = 'L'
        private const val OCCUPIED_SEAT: Char = '#'
    }
}