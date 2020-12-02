package com.bbrakenhoff.adventofcode.day02

import com.bbrakenhoff.adventofcode.Day
import com.bbrakenhoff.adventofcode.PuzzleInputReader

class Day02 : Day {

    override val enabledFocusedPrint: Boolean = true

    private val policyPasswordMap = readPuzzleInput()

    override fun partOne(): String {
        val validatedPasswords = policyPasswordMap.map { it.first.isPasswordValid(it.second) }
        val validPasswordCount = validatedPasswords.count { it }

        return "$validPasswordCount"
    }

    override fun partTwo(): String {
        return ""
    }

    private fun readPuzzleInput(): List<Pair<PasswordPolicy, String>> {
        val puzzleInput = PuzzleInputReader.read(2)

        return puzzleInput.map {
            mapPolicyAndPasswordFromInputLine(it)
        }
    }

    private fun mapPolicyAndPasswordFromInputLine(inputLine: String): Pair<PasswordPolicy, String> {
        val splitLine = inputLine.split(':')

        val policy: String = splitLine.first().trim()
        val password: String = splitLine.last().trim()

        return Pair(PasswordPolicy.createFromPuzzleInput(policy), password)
    }
}