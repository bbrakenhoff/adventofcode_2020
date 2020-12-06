package com.bbrakenhoff.adventofcode.day06

import com.bbrakenhoff.adventofcode.Day
import com.bbrakenhoff.adventofcode.PuzzleInputReader

class Day06 : Day {
    override val enabledFocusedPrint: Boolean = true

    private val customsDeclarationGroups: List<CustomsDeclarationGroup>

    init {
        val rawCustomDeclarationAnswerLines: List<String> = PuzzleInputReader.read(6)
        val groupedAnswerLines: List<List<String>> = PuzzleInputReader.groupByBlankLines(rawCustomDeclarationAnswerLines)
        customsDeclarationGroups = groupedAnswerLines.map { CustomsDeclarationGroup(it) }
    }

    override fun partOne(): String {
        val yesAnswerCountPerGroup = customsDeclarationGroups.map { it.countYesAnswers() }
        val yesAnswerCount = yesAnswerCountPerGroup.fold(0, { total: Int, next: Int -> total + next })
        return "$yesAnswerCount"
    }

    override fun partTwo(): String {
        return ""
    }
}
