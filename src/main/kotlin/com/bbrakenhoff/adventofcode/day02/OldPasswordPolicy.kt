package com.bbrakenhoff.adventofcode.day02

@Suppress("DataClassPrivateConstructor")
data class OldPasswordPolicy(
    override val requiredChar: Char = ' ',
    val minOccurances: Int = 0,
    val maxOccurances: Int = 0
) : PasswordPolicy(requiredChar) {

    override fun isPasswordValid(password: String): Boolean {
        val occurancesRequiredChar = password.count { it == requiredChar }
        return occurancesRequiredChar in minOccurances..maxOccurances
    }
}