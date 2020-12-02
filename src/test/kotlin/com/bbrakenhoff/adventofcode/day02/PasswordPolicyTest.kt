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
}