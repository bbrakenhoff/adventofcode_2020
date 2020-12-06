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
        val yesAnswerCountPerGroup: List<Int> = customsDeclarationGroups.map { it.countAllYesAnswers() }
        val yesAnswerCount: Int = countAllYesAnswers(yesAnswerCountPerGroup)
        return "$yesAnswerCount"
    }

    private fun countAllYesAnswers(yesAnswerCountPerGroup: List<Int>): Int = yesAnswerCountPerGroup.fold(0, { total: Int, next: Int -> total + next })

    override fun partTwo(): String {
        val unanimouslyYesAnswerCountPerGroup = customsDeclarationGroups.map { it.countUnanimouslyYesAnswers() }
        val yesAnswerCount: Int = countAllYesAnswers(unanimouslyYesAnswerCountPerGroup)
        return "$yesAnswerCount"
    }
}
