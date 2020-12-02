package com.bbrakenhoff.adventofcode.day02

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class OldPasswordPolicyTest {

    @Test
    fun `should return false when required char does not have min occurances in password`() {
        val password = "cdefg"
        val policy = PasswordPolicyFactory.createOldPolicy("1-3 b: $password")

        val isValid = policy.isPasswordValid()

        isValid shouldBe false
    }

    @Test
    fun `should return false when required char occurs more than max in password`() {
        val password = "abcdeaaa"
        val policy = PasswordPolicyFactory.createOldPolicy("1-3 a: $password")

        val isValid = policy.isPasswordValid()

        isValid shouldBe false
    }

    @Test
    fun `should return true when required char occurs wihtin range in password`() {
        val password = "abcde"
        val policy = PasswordPolicyFactory.createOldPolicy("1-3 a: $password")

        val isValid = policy.isPasswordValid()

        isValid shouldBe true
    }
}
