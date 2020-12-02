package com.bbrakenhoff.adventofcode.day02

@Suppress("DataClassPrivateConstructor")
data class PasswordPolicy private constructor(
    val requiredChar: Char = ' ',
    val firstAllowedPosition: Int = 0,
    val secondAllowedPosition: Int = 0
) {

    fun isPasswordValid(password: String): Boolean {
        val charAtFirstAllowedPosition = password[firstAllowedPosition]
        val charAtSecondAllowedPosition = password[secondAllowedPosition]

        val firstAllowedPositionsIsRequiredChar = charAtFirstAllowedPosition == requiredChar
        val secondAllowedPositionsIsRequiredChar = charAtSecondAllowedPosition == requiredChar

        var isValid = firstAllowedPositionsIsRequiredChar

        isValid = if (isValid) {
            !secondAllowedPositionsIsRequiredChar
        } else {
            secondAllowedPositionsIsRequiredChar
        }

        return isValid
    }

    companion object {
        fun createFromPuzzleInput(input: String): PasswordPolicy {
            val splitInput = input.split(' ')
            val requiredChar = splitInput.last().first()

            val splitMinMaxOccurances = splitInput.first().split('-')
            val firstAllowedPosition = splitMinMaxOccurances.first().toInt() - 1
            val secondAllowedPosition = splitMinMaxOccurances.last().toInt() - 1

            return PasswordPolicy(requiredChar, firstAllowedPosition, secondAllowedPosition)
        }
    }
}