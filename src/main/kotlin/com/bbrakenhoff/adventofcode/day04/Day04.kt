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
                createPassportFromBatchLine(singlePassportLines)
                singlePassportLines = mutableListOf()
            } else {
                singlePassportLines.add(it)
            }
        }

        if (singlePassportLines.isNotEmpty()) {
            createPassportFromBatchLine(singlePassportLines)
        }
    }

    private fun createPassportFromBatchLine(singlePassportLines: MutableList<String>) {
        val comb: String = singlePassportLines.joinToString(" ")
        val passport: Passport = Passport(singlePassportLines.joinToString(" "))
        println(comb)
        passportBatch.add(passport)
    }

    override fun partOne(): String {
        val countValidPassports: Int = passportBatch.count { it.isValid() }
        return "$countValidPassports"
    }

    override fun partTwo(): String {
        return ""
    }
}
