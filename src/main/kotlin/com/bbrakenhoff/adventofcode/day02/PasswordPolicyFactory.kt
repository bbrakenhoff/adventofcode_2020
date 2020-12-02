package com.bbrakenhoff.adventofcode.day02

object PasswordPolicyFactory {

    fun createOldPolicy(puzzleInput: String): OldPasswordPolicy {
        val splitPuzzleInput = splitPuzzleInput(puzzleInput)
        return OldPasswordPolicy(splitPuzzleInput.first, splitPuzzleInput.second, splitPuzzleInput.third)
    }

    fun createPolicy(puzzleInput: String): NewPasswordPolicy {
        val splitPuzzleInput = splitPuzzleInput(puzzleInput)
        return NewPasswordPolicy(splitPuzzleInput.first, splitPuzzleInput.second - 1, splitPuzzleInput.third - 1)
    }

    private fun splitPuzzleInput(puzzleInput: String): Triple<Char, Int, Int> {
        val splitInput = puzzleInput.split(' ')
        val requiredChar = splitInput.last().first()

        val splitOccuranceNumbers = splitInput.first().split('-')
        val first = splitOccuranceNumbers.first().toInt()
        val second = splitOccuranceNumbers.last().toInt()

        return Triple(requiredChar, first, second)
    }
}