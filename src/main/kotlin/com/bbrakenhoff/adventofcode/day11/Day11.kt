package com.bbrakenhoff.adventofcode.day11

import com.bbrakenhoff.adventofcode.Day
import com.bbrakenhoff.adventofcode.PuzzleInputReader

class Day11 : Day {

    override val enabledFocusedPrint: Boolean = false

    private val initialSeatLayout: List<String> = PuzzleInputReader.read(11)

    override fun partOne(): String {
        val seatLayout: SeatLayout = SeatLayout(initialSeatLayout, SurroundingSeatsFinder(), 4)

        return "${countOccpiedSeats(seatLayout)}"
    }

    private fun countOccpiedSeats(seatLayout: SeatLayout): Int {
        val finalSeatLayout: List<List<Seat>> = seatLayout.findFinalSeatLayout()
        return finalSeatLayout.sumBy { it.count { seat: Seat -> seat.isOccupied } }
    }

    override fun partTwo(): String {
        val seatLayout: SeatLayout = SeatLayout(initialSeatLayout, FirstSeenSeatsFinder(), 5)

        return "${countOccpiedSeats(seatLayout)}"
    }

}
