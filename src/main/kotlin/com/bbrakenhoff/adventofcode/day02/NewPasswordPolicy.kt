package com.bbrakenhoff.adventofcode.day02

@Suppress("DataClassPrivateConstructor")
data class NewPasswordPolicy(
    override val requiredChar: Char = ' ',
    val firstAllowedPosition: Int = 0,
    val secondAllowedPosition: Int = 0
) : PasswordPolicy(requiredChar) {

    override fun isPasswordValid(password: String): Boolean {
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
}