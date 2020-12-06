package com.bbrakenhoff.adventofcode.day06

import com.bbrakenhoff.adventofcode.Day
import com.bbrakenhoff.adventofcode.PuzzleInputReader

class Day06 : Day {
    override val enabledFocusedPrint: Boolean = true

    private val customsDeclarationGroup: List<CustomsDeclarationGroup>

    init {
        val rawCustomDeclarationLines: List<String> = PuzzleInputReader.read(6)
        val rawCustomDeclarationGroupsLines: List<List<String>> = PuzzleInputReader.groupByBlankLines(rawCustomDeclarationLines)
        customsDeclarationGroup = rawCustomDeclarationGroupsLines.map { CustomsDeclarationGroup(it) }
    }

    override fun partOne(): String {
        val yesAnswerCountPerGroup: List<Int> = customsDeclarationGroup.map { it.countAllYesAnswers() }
        val totalYesAnswerCount: Int = sumYesAnswers(yesAnswerCountPerGroup)
        return "$totalYesAnswerCount"
    }

    private fun sumYesAnswers(yesAnswerCountPerGroup: List<Int>): Int = yesAnswerCountPerGroup.fold(0, { total: Int, next: Int -> total + next })

    override fun partTwo(): String {
        val unanimouslyYesAnswerCountPerGroup = customsDeclarationGroup.map { it.countUnanimouslyYesAnswers() }
        val totalYesAnswerCount: Int = sumYesAnswers(unanimouslyYesAnswerCountPerGroup)
        return "$totalYesAnswerCount"
    }
}
