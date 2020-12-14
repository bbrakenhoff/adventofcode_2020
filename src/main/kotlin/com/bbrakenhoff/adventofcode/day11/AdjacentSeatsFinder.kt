package com.bbrakenhoff.adventofcode.day11

abstract class AdjacentSeatsFinder {

    abstract fun findAdjacentSeats(seat: Seat, seatLayout: List<List<Seat>>): List<Seat>

    protected fun positionWithinBounds(position: SeatPosition, currentSeatLayout: List<List<Seat>>): Boolean {
        val seatLayoutWidth: Int = currentSeatLayout.first().size
        val seatLayoutHeight: Int = currentSeatLayout.size
        return position.x in 0 until seatLayoutWidth && position.y in 0 until seatLayoutHeight
    }
}
