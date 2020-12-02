package com.bbrakenhoff.adventofcode.day02

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class OldPasswordPolicyTest {

    @Test
    fun `should return false when required char does not have min occurances in password`() {
        val policy = PasswordPolicyFactory.createOldPolicy("1-3 b")
        val password = "cdefg"

        val isValid = policy.isPasswordValid(password)

        isValid shouldBe false
    }

    @Test
    fun `should return false when required char occurs more than max in password`() {
        val policy = PasswordPolicyFactory.createOldPolicy("1-3 a")
        val password = "abcdeaaa"

        val isValid = policy.isPasswordValid(password)

        isValid shouldBe false
    }

    @Test
    fun `should return true when required char occurs wihtin range in password`() {
        val policy = PasswordPolicyFactory.createOldPolicy("1-3 a")
        val password = "abcde"

        val isValid = policy.isPasswordValid(password)

        isValid shouldBe true
    }
}