package com.bbrakenhoff.adventofcode.day02

abstract class PasswordPolicy(open val requiredChar:Char) {

    abstract fun isPasswordValid(password: String): Boolean
}