package com.bbrakenhoff.adventofcode.day02

abstract class PasswordPolicy(val requiredChar:Char, val digitLeft:Int, val digitRight:Int,val password: String) {

    abstract fun isPasswordValid(): Boolean
}
