package com.bbrakenhoff.adventofcode

import java.io.File

object PuzzleInputReader {

    fun read(dayNumber: Int) = File(findFile(dayNumber)).useLines { it.toList() }

    private fun findFile(dayNumber: Int) = String.format(PuzzleInputFilePath, buildDayNumberText(dayNumber))

    private fun buildDayNumberText(dayNumber: Int): String = dayNumber.toString().padStart(2, '0')

    private const val PuzzleInputFilePath = "./src/main/puzzle-input/day%s.txt"
}
