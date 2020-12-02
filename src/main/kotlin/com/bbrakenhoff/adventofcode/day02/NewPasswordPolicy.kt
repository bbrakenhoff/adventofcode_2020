package com.bbrakenhoff.adventofcode.day02

@Suppress("DataClassPrivateConstructor")
class NewPasswordPolicy(requiredChar: Char, firstAllowedPosition: Int, secondAllowedPosition: Int, password: String) :
    PasswordPolicy(requiredChar, firstAllowedPosition, secondAllowedPosition, password) {

    override fun isPasswordValid(): Boolean {
        val charAtFirstAllowedPosition = password[digitLeft - 1]
        val charAtSecondAllowedPosition = password[digitRight - 1]

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
}
