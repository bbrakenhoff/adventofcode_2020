package com.bbrakenhoff.adventofcode.day11

data class Seat(val position: SeatPosition, private var _char: Char) {

    val char: Char
        get() = _char

    private val isSeat: Boolean
        get() = _char == EMPTY_SEAT || _char == OCCUPIED_SEAT
    val isFloor: Boolean = !isSeat

    val isOccupied: Boolean
        get() = _char == OCCUPIED_SEAT

    fun positionTop(): SeatPosition = SeatPosition(position.column, position.row - 1)

    fun positionBottom(): SeatPosition = SeatPosition(position.column, position.row + 1)

    fun positionLeft(): SeatPosition = SeatPosition(position.column - 1, position.row)

    fun positionRight(): SeatPosition = SeatPosition(position.column + 1, position.row)

    fun positionLeftTop(): SeatPosition = SeatPosition(position.column - 1, position.row - 1)

    fun positionRightTop(): SeatPosition = SeatPosition(position.column + 1, position.row - 1)

    fun positionRightBottom(): SeatPosition = SeatPosition(position.column + 1, position.row + 1)

    fun positionLeftBottom(): SeatPosition = SeatPosition(position.column - 1, position.row + 1)

    companion object {
        private const val EMPTY_SEAT: Char = 'L'
        private const val OCCUPIED_SEAT: Char = '#'
    }
}
