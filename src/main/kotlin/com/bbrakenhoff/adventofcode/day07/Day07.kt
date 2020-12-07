package com.bbrakenhoff.adventofcode.day07

import com.bbrakenhoff.adventofcode.Day
import com.bbrakenhoff.adventofcode.PuzzleInputReader

class Day07 : Day {

    override val enabledFocusedPrint: Boolean = true

    private val luggageRules: List<String> = PuzzleInputReader.read(7)
    private val luggageProcessor: LuggageProcessor = LuggageProcessor(luggageRules)

    override fun partOne(): String {
        val usableBags: List<Bag> = luggageProcessor.findBagsToCarry("shiny gold")
        val usableBagsCount = usableBags.size
        return "$usableBagsCount"
    }

    override fun partTwo(): String {
        return ""
    }
}
