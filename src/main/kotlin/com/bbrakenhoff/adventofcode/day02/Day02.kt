package com.bbrakenhoff.adventofcode.day02

import com.bbrakenhoff.adventofcode.Day
import com.bbrakenhoff.adventofcode.PuzzleInputReader

class Day02 : Day {

    override val enabledFocusedPrint: Boolean = true

    private val policyPasswordMap = PuzzleInputReader.read(2)

    override fun partOne(): String {
        val policies = policyPasswordMap.map { PasswordPolicyFactory.createOldPolicy(it) }
        val validPasswordCount = countValidPasswords(policies)

        return validPasswordCount
    }

    private fun countValidPasswords(policies: List<PasswordPolicy>): String {
        val validPasswords = policies.map { it.isPasswordValid() }
        val validPasswordCount = validPasswords.count { it }
        return "$validPasswordCount"
    }

    override fun partTwo(): String {
        val policies = policyPasswordMap.map { PasswordPolicyFactory.createNewPolicy(it) }
        val validPasswordCount = countValidPasswords(policies)

        return validPasswordCount
    }
}
