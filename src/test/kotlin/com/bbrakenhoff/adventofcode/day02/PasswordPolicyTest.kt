package com.bbrakenhoff.adventofcode.day02

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class PasswordPolicyTest {

    @Test
    fun `should create a password policy from puzzle input`() {
        val puzzleInput = "12-16 v"

        val result = PasswordPolicy.createFromPuzzleInput(puzzleInput)

        result.requiredChar shouldBe 'v'
        result.minOccurances shouldBe 12
        result.maxOccurances shouldBe 16
    }

    @Test
    fun `should return false when required char does not have min occurances in password`() {
        val policy = PasswordPolicy.createFromPuzzleInput("1-3 b")
        val password = "cdefg"

        val isValid = policy.isPasswordValid(password)

        isValid shouldBe false
    }

    @Test
    fun `should return false when required char occurs more than max in password`() {
        val policy = PasswordPolicy.createFromPuzzleInput("1-3 a")
        val password = "abcdeaaa"

        val isValid = policy.isPasswordValid(password)

        isValid shouldBe false
    }

    @Test
    fun `should return true when required char occurs wihtin range in password`() {
        val policy = PasswordPolicy.createFromPuzzleInput("1-3 a")
        val password = "abcde"

        val isValid = policy.isPasswordValid(password)

        isValid shouldBe true
    }
}