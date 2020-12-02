package com.bbrakenhoff.adventofcode.day02

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class NewPasswordPolicyTest {

    @Test
    fun `should return false when required char does not have min occurances in password`() {
        val policy = PasswordPolicyFactory.createNewPolicy("1-3 b")
        val password = "cdefg"

        val isValid = policy.isPasswordValid(password)

        isValid shouldBe false
    }

    @Test
    fun `should return false when required char occurs on both positions`() {
        val policy = PasswordPolicyFactory.createNewPolicy("1-3 a")
        val password = "ccccccccc"

        val isValid = policy.isPasswordValid(password)

        isValid shouldBe false
    }

    @Test
    fun `should return true when required char occurs on one of allowed positions`() {
        val policy = PasswordPolicyFactory.createNewPolicy("1-3 a")
        val password = "abcde"

        val isValid = policy.isPasswordValid(password)

        isValid shouldBe true
    }
}