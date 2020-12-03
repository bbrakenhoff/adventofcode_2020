package com.bbrakenhoff.adventofcode.day02

object PasswordPolicyFactory {

    fun createOldPolicy(puzzleInput: String): OldPasswordPolicy {
        val matchedInput: MatchResult = POLICY_AND_PASSWORD_MATCHER.find(puzzleInput)!!
        val requiredChar: Char = matchedInput.groupValues[3].first()
        val first: Int = matchedInput.groupValues[1].toInt()
        val second: Int = matchedInput.groupValues[2].toInt()
        val password: String = matchedInput.groupValues[4]

        return OldPasswordPolicy(requiredChar, first, second, password)
    }

    fun createNewPolicy(puzzleInput: String): NewPasswordPolicy {
        val matchedInput: MatchResult = POLICY_AND_PASSWORD_MATCHER.find(puzzleInput)!!
        val requiredChar: Char = matchedInput.groupValues[3].first()
        val first: Int = matchedInput.groupValues[1].toInt()
        val second: Int = matchedInput.groupValues[2].toInt()
        val password: String = matchedInput.groupValues[4]

        return NewPasswordPolicy(requiredChar, first, second, password)
    }

    private val POLICY_AND_PASSWORD_MATCHER: Regex = Regex("([\\d]*)-([\\d]*) ([a-z]): ([a-z]*)")
}
