package com.bbrakenhoff.adventofcode.day04

import com.bbrakenhoff.adventofcode.Day
import com.bbrakenhoff.adventofcode.PuzzleInputReader

class Day04 : Day {

    override val enabledFocusedPrint: Boolean = true

    private val passportBatch: MutableList<Passport> = mutableListOf()

    init {
        readPassports()
    }

    private fun readPassports() {
        val rawPassportBatchLines: List<String> = PuzzleInputReader.read(4)

        var singlePassportLines: MutableList<String> = mutableListOf()

        rawPassportBatchLines.forEach {
            if (it.isBlank()) {
                val passport = Passport(singlePassportLines.joinToString(" "))
                passportBatch.add(passport)
                singlePassportLines = mutableListOf()
            } else {
                singlePassportLines.add(it)
            }
        }
    }

    override fun partOne(): String {
        return "${passportBatch.size}"
    }

    override fun partTwo(): String {
        return ""
    }
}