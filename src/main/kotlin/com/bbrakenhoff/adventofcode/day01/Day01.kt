package com.bbrakenhoff.adventofcode.day01

import com.bbrakenhoff.adventofcode.Day
import com.bbrakenhoff.adventofcode.PuzzleInputReader

class Day01 : Day {

    private val expenseReport = PuzzleInputReader.read(1).map { it.toInt() }

    override val enabledFocusedPrint: Boolean = false

    override fun partOne(): String {
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

    override fun partTwo(): String {
        var expenseTriple = Triple(0, 0, 0)

        outer@ for (first in expenseReport) {
            for (second in expenseReport) {
                for (third in expenseReport) {
                    expenseTriple = Triple(first, second, third)
                    if (expenseTripleSumIs2020(expenseTriple)) {
                        break@outer
                    }
                }
            }
        }

        return "${expenseTriple.first * expenseTriple.second * expenseTriple.third}"
    }

    private fun expenseTripleSumIs2020(expenseTriple: Triple<Int, Int, Int>) = expenseTriple.first + expenseTriple.second + expenseTriple.third == 2020
}
