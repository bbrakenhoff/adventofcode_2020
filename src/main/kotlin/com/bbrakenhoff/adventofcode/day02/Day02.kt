package com.bbrakenhoff.adventofcode.day02

import com.bbrakenhoff.adventofcode.Day
import com.bbrakenhoff.adventofcode.PuzzleInputReader

class Day02 : Day {

    override val enabledFocusedPrint: Boolean = true

    private val policyPasswordMap = readPuzzleInput()

    private fun readPuzzleInput(): List<Pair<String, String>> {
        val puzzleInput = PuzzleInputReader.read(2)

        return puzzleInput.map {
            mapOldPolicyAndPasswordFromInputLine(it)
        }
    }

    private fun mapOldPolicyAndPasswordFromInputLine(inputLine: String): Pair<String, String> {
        val splitLine = inputLine.split(':')

        val policy: String = splitLine.first().trim()
        val password: String = splitLine.last().trim()

        return Pair(policy, password)
    }

    override fun partOne(): String {
        val policies = policyPasswordMap.map { Pair(PasswordPolicyFactory.createOldPolicy(it.first), it.second) }
        val validPasswordCount = countValidPasswords(policies)

        return validPasswordCount
    }

    private fun countValidPasswords(policies: List<Pair<PasswordPolicy, String>>): String {
        val validatedPasswords = policies.map { it.first.isPasswordValid(it.second) }
        val validPasswordCount = validatedPasswords.count { it }
        return "$validPasswordCount"
    }

    override fun partTwo(): String {
        val policies = policyPasswordMap.map { Pair(PasswordPolicyFactory.createPolicy(it.first), it.second) }
        val validPasswordCount = countValidPasswords(policies)

        return validPasswordCount
    }
}