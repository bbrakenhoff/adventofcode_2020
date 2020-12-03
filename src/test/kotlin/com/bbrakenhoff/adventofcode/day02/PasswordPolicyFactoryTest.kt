package com.bbrakenhoff.adventofcode.day02

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class PasswordPolicyFactoryTest {

    @Test
    fun `should create an old password policy from puzzle input`() {
        val puzzleInput: String = "12-16 v: abcdef"

        val result: OldPasswordPolicy = PasswordPolicyFactory.createOldPolicy(puzzleInput)

        result.requiredChar shouldBe 'v'
        result.digitLeft shouldBe 12
        result.digitRight shouldBe 16
    }

    @Test
    fun `should create a password policy from puzzle input`() {
        val puzzleInput: String = "3-13 s: qcvwtwstkvrrfzs"

        val result: NewPasswordPolicy = PasswordPolicyFactory.createNewPolicy(puzzleInput)

        result.requiredChar shouldBe 's'
        result.digitLeft shouldBe 3
        result.digitRight shouldBe 13
    }
}
