package com.bbrakenhoff.adventofcode.day11

data class Seat(val position: SeatPosition, private var _char: Char) {

    val char: Char
        get() = _char

    val isSeat: Boolean
        get() = _char == EMPTY_SEAT_CHAR || _char == OCCUPIED_SEAT_CHAR
    val isFloor: Boolean = !isSeat

    val isOccupied: Boolean
        get() = _char == OCCUPIED_SEAT_CHAR

    companion object {
        const val EMPTY_SEAT_CHAR: Char = 'L'
        const val OCCUPIED_SEAT_CHAR: Char = '#'
    }
}
