package com.bbrakenhoff.adventofcode.day11

import com.bbrakenhoff.adventofcode.Day
import com.bbrakenhoff.adventofcode.PuzzleInputReader

class Day11 : Day {
    override val enabledFocusedPrint: Boolean = true

    private val initialSeatLayout: MutableList<String> = PuzzleInputReader.read(11).toMutableList()

    override fun partOne(): String {
        val seatLayout: SeatLayout = SeatLayout(initialSeatLayout)
        val finalSeeatLayout = seatLayout.findFinalSeatLayout()
        val mapped = seatLayout.mapToSeats(finalSeeatLayout)
        val occupied = mapped.sumBy { it.count { seat -> seat.isOccupied } }
        return "$occupied"
    }

    override fun partTwo(): String {
        return ""
    }
}
