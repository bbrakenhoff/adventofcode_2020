package com.bbrakenhoff.adventofcode.day02

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class NewPasswordPolicyTest {

    @Test
    fun `should return false when required char does not have min occurances in password`() {
        val password = "cdefg"
        val policy = PasswordPolicyFactory.createNewPolicy("1-3 b: $password")

        val isValid = policy.isPasswordValid()

        isValid shouldBe false
    }

    @Test
    fun `should return false when required char occurs on both positions`() {
        val password = "ccccccccc"
        val policy = PasswordPolicyFactory.createNewPolicy("1-3 a: $password")

        val isValid = policy.isPasswordValid()

        isValid shouldBe false
    }

    @Test
    fun `should return true when required char occurs on one of allowed positions`() {
        val password = "abcde"
        val policy = PasswordPolicyFactory.createNewPolicy("1-3 a: $password")

        val isValid = policy.isPasswordValid()

        isValid shouldBe true
    }
}
