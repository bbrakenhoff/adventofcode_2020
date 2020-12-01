package com.bbrakenhoff.adventofcode.day01

import com.bbrakenhoff.adventofcode.Day
import com.bbrakenhoff.adventofcode.PuzzleInputReader

class Day01 : Day {

    private val expenseReport = PuzzleInputReader.read(1).map { it.toInt() }

    override val enabledFocusedPrint: Boolean = false

    override fun partA(): String {
        var expensePair = Pair(0, 0)

        outer@ for (indexOut in expenseReport.indices) {
            val filteredPuzzleInput = filterAboveIndex(indexOut)

            for (indexIn in filteredPuzzleInput.indices) {
                expensePair = Pair(expenseReport[indexOut], filteredPuzzleInput[indexIn])
                if (expensePairSumIs2020(expensePair)) {
                    break@outer
                }
            }
        }

        return "${expensePair.first * expensePair.second}"
    }

    private fun filterAboveIndex(indexOut: Int) = expenseReport.filterIndexed { indexIn, _ -> indexIn > indexOut }

    private fun expensePairSumIs2020(expensePair: Pair<Int, Int>) = expensePair.first + expensePair.second == 2020

    override fun partB(): String {
        TODO("Not yet implemented")
    }

}
