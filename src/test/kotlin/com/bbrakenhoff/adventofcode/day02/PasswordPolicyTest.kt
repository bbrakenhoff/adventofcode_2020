package com.bbrakenhoff.adventofcode.day02

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class PasswordPolicyTest {

    @Test
    fun `should create a password policy from puzzle input`() {
        val puzzleInput = "12-16 v"

        val result = PasswordPolicy.createFromPuzzleInput(puzzleInput)

        result.requiredChar shouldBe 'v'
        result.firstAllowedPosition  shouldBe 11
        result.secondAllowedPosition shouldBe 15
    }

    @Test
    fun `should return false when required char does not have min occurances in password`() {
        val policy = PasswordPolicy.createFromPuzzleInput("1-3 b")
        val password = "cdefg"

        val isValid = policy.isPasswordValid(password)

        isValid shouldBe false
    }

    @Test
    fun `should return false when required char occurs on both positions`() {
        val policy = PasswordPolicy.createFromPuzzleInput("1-3 a")
        val password = "ccccccccc"

        val isValid = policy.isPasswordValid(password)

        isValid shouldBe false
    }

    @Test
    fun `should return true when required char occurs on one of allowed positions`() {
        val policy = PasswordPolicy.createFromPuzzleInput("1-3 a")
        val password = "abcde"

        val isValid = policy.isPasswordValid(password)

        isValid shouldBe true
    }
}