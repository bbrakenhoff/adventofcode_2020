package com.bbrakenhoff.adventofcode.day04

import com.bbrakenhoff.adventofcode.Day
import com.bbrakenhoff.adventofcode.PuzzleInputReader

class Day04 : Day {

    override val enabledFocusedPrint: Boolean = false

    private var passportBatch: List<Passport> = mutableListOf()

    init {
        readPassports()
    }

    private fun readPassports() {
        val rawPassportBatchLines: List<String> = PuzzleInputReader.read(4)
        val groupedPassportBatchLines: List<List<String>> = PuzzleInputReader.groupByBlankLines(rawPassportBatchLines)
        passportBatch = groupedPassportBatchLines.map { Passport(it.joinToString(" ")) }
    }

    override fun partOne(): String {
        val countValidPassports: Int = passportBatch.count { it.allFieldsPresent() }
        return "$countValidPassports"
    }

    override fun partTwo(): String {
        val countValidPassports: Int = passportBatch.count { it.isValid() }
        return "$countValidPassports"
    }
}
