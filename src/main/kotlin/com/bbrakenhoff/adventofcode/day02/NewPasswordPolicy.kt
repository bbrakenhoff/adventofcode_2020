package com.bbrakenhoff.adventofcode.day02

@Suppress("DataClassPrivateConstructor")
class NewPasswordPolicy(requiredChar: Char, firstAllowedPosition: Int, secondAllowedPosition: Int, password: String) :
    PasswordPolicy(requiredChar, firstAllowedPosition, secondAllowedPosition, password) {

    override fun isPasswordValid(): Boolean {
        val charAtFirstAllowedPosition: Char = password[digitLeft - 1]
        val charAtSecondAllowedPosition: Char = password[digitRight - 1]

        val firstAllowedPositionsIsRequiredChar: Boolean = charAtFirstAllowedPosition == requiredChar
        val secondAllowedPositionsIsRequiredChar: Boolean = charAtSecondAllowedPosition == requiredChar

        var isValid: Boolean = firstAllowedPositionsIsRequiredChar

        isValid = if (isValid) {
            !secondAllowedPositionsIsRequiredChar
        } else {
            secondAllowedPositionsIsRequiredChar
        }

        return isValid
    }
}
