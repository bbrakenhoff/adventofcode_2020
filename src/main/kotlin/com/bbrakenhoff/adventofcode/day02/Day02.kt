package com.bbrakenhoff.adventofcode.day02

import com.bbrakenhoff.adventofcode.Day
import com.bbrakenhoff.adventofcode.PuzzleInputReader

class Day02 : Day {

    override val enabledFocusedPrint: Boolean = true

    private val policyPasswordMap: List<String> = PuzzleInputReader.read(2)

    override fun partOne(): String {
        val policies: List<OldPasswordPolicy> = policyPasswordMap.map { PasswordPolicyFactory.createOldPolicy(it) }
        val validPasswordCount: String = countValidPasswords(policies)

        return validPasswordCount
    }

    private fun countValidPasswords(policies: List<PasswordPolicy>): String {
        val validPasswords: List<Boolean> = policies.map { it.isPasswordValid() }
        val validPasswordCount: Int = validPasswords.count { it }
        return "$validPasswordCount"
    }

    override fun partTwo(): String {
        val policies: List<NewPasswordPolicy> = policyPasswordMap.map { PasswordPolicyFactory.createNewPolicy(it) }
        val validPasswordCount: String = countValidPasswords(policies)

        return validPasswordCount
    }
}
