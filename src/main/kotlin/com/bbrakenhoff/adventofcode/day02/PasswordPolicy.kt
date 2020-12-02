package com.bbrakenhoff.adventofcode.day02

@Suppress("DataClassPrivateConstructor")
data class PasswordPolicy private constructor(
    val requiredChar: Char = ' ',
    val minOccurances: Int = 0,
    val maxOccurances: Int = 0
) {

    fun isPasswordValid(password: String): Boolean {
        val occurancesRequiredChar = password.count { it == requiredChar }
        return occurancesRequiredChar in minOccurances..maxOccurances
    }

    companion object {
        fun createFromPuzzleInput(input: String): PasswordPolicy {
            val splitInput = input.split(' ')
            val requiredChar = splitInput.last().first()

            val splitMinMaxOccurances = splitInput.first().split('-')
            val minOccurances = splitMinMaxOccurances.first().toInt()
            val maxOccurances = splitMinMaxOccurances.last().toInt()

            return PasswordPolicy(requiredChar, minOccurances, maxOccurances)
        }
    }
}