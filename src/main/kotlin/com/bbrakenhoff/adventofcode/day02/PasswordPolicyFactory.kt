package com.bbrakenhoff.adventofcode.day02

object PasswordPolicyFactory {

    fun createOldPolicy(puzzleInput: String): OldPasswordPolicy {
        val matchedInput: MatchResult = policyAndPasswordMatcher.find(puzzleInput)!!
        val requiredChar = matchedInput.groupValues[3].first()
        val first = matchedInput.groupValues[1].toInt()
        val second = matchedInput.groupValues[2].toInt()
        val password = matchedInput.groupValues[4]

        return OldPasswordPolicy(requiredChar, first, second, password)
    }

    fun createNewPolicy(puzzleInput: String): NewPasswordPolicy {
        val matchedInput: MatchResult = policyAndPasswordMatcher.find(puzzleInput)!!
        val requiredChar = matchedInput.groupValues[3].first()
        val first = matchedInput.groupValues[1].toInt()
        val second = matchedInput.groupValues[2].toInt()
        val password = matchedInput.groupValues[4]

        return NewPasswordPolicy(requiredChar, first, second, password)
    }

    private val policyAndPasswordMatcher = Regex("([\\d]*)-([\\d]*) ([a-z]): ([a-z]*)")
}
