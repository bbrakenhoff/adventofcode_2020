package com.bbrakenhoff.adventofcode.day02

@Suppress("DataClassPrivateConstructor")
class OldPasswordPolicy(requiredChar: Char, firstAllowedPosition: Int, secondAllowedPosition: Int, password: String) :
    PasswordPolicy(requiredChar, firstAllowedPosition, secondAllowedPosition, password) {

    override fun isPasswordValid(): Boolean {
        val occurancesRequiredChar = password.count { it == requiredChar }
        return occurancesRequiredChar in digitLeft..digitRight
    }
}
