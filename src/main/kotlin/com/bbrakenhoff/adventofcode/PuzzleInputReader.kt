package com.bbrakenhoff.adventofcode

import java.io.File

object PuzzleInputReader {

    fun read(dayNumber: Int): List<String> = File(findFile(dayNumber)).useLines { it.toList() }

    private fun findFile(dayNumber: Int): String = String.format(PUZZLE_INPUT_FILE_PATH, buildDayNumberText(dayNumber))

    private fun buildDayNumberText(dayNumber: Int): String = dayNumber.toString().padStart(2, '0')

    fun groupByBlankLines(readPuzzleInput: List<String>): List<List<String>> {
        val groupedLines: MutableList<List<String>> = mutableListOf()
        var group: MutableList<String> = mutableListOf()

        readPuzzleInput.forEach {
            if (it.isBlank()) {
                groupedLines.add(group)
                group = mutableListOf()
            } else {
                group.add(it)
            }
        }

        if (group.isNotEmpty()) {
            groupedLines.add(group)
        }

        return groupedLines
    }

    private const val PUZZLE_INPUT_FILE_PATH: String = "./src/main/puzzle-input/day%s.txt"
}
