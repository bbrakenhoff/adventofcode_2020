package com.bbrakenhoff.adventofcode

import java.io.File

object PuzzleInputReader {

    fun read(dayNumber: Int): List<String> = File(findFile(dayNumber)).useLines { it.toList() }

    private fun findFile(dayNumber: Int): String = String.format(PUZZLE_INPUT_FILE_PATH, buildDayNumberText(dayNumber))

    private fun buildDayNumberText(dayNumber: Int): String = dayNumber.toString().padStart(2, '0')

    private const val PUZZLE_INPUT_FILE_PATH: String = "./src/main/puzzle-input/day%s.txt"
}
