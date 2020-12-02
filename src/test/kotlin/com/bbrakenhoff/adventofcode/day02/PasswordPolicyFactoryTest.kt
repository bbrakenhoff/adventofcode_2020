package com.bbrakenhoff.adventofcode.day02

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PasswordPolicyFactoryTest {

    @Test
    fun `should create an old password policy from puzzle input`() {
        val puzzleInput = "12-16 v"

        val result = PasswordPolicyFactory.createOldPolicy(puzzleInput)

        result.requiredChar shouldBe 'v'
        result.minOccurances shouldBe 12
        result.maxOccurances shouldBe 16
    }

    @Test
    fun `should create a password policy from puzzle input`() {
        val puzzleInput = "12-16 v"

        val result = PasswordPolicyFactory.createPolicy(puzzleInput)

        result.requiredChar shouldBe 'v'
        result.firstAllowedPosition shouldBe 11
        result.secondAllowedPosition shouldBe 15
    }
}