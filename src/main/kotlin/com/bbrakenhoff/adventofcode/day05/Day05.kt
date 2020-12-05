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
        return ""
    }
}
