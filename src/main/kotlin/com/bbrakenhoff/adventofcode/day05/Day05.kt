package com.bbrakenhoff.adventofcode.day05

import com.bbrakenhoff.adventofcode.Day
import com.bbrakenhoff.adventofcode.PuzzleInputReader

class Day05 : Day {

    override val enabledFocusedPrint: Boolean = true

    private val boardingPasses: List<BoardingPass> = PuzzleInputReader.read(5).map { BoardingPass(it) }

    override fun partOne(): String {
        val seatIds: List<Int> = boardingPasses.map { it.findSeatId() }
        val highestSeatId = seatIds.max()
        return "$highestSeatId"
    }

    override fun partTwo(): String {
        val sortedSeatIds: List<Int> = boardingPasses.map { it.findSeatId() }.sorted()

        var mySeatId = -1
        var i = 0

        while (mySeatId == -1 && i < sortedSeatIds.size) {
            if (sortedSeatIds[i] + 2 == sortedSeatIds[i + 1]) {
                mySeatId = sortedSeatIds[i] + 1
            }

            i++
        }

        return "$mySeatId"
    }
}
