package com.bbrakenhoff.adventofcode.day02

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class OldPasswordPolicyTest {

    @Test
    fun `should return false when required char does not have min occurances in password`() {
        val password: String = "cdefg"
        val policy: OldPasswordPolicy = PasswordPolicyFactory.createOldPolicy("1-3 b: $password")

        policy.isPasswordValid() shouldBe false
    }

    @Test
    fun `should return false when required char occurs more than max in password`() {
        val password: String = "abcdeaaa"
        val policy: OldPasswordPolicy = PasswordPolicyFactory.createOldPolicy("1-3 a: $password")

        policy.isPasswordValid() shouldBe false
    }

    @Test
    fun `should return true when required char occurs wihtin range in password`() {
        val password: String = "abcde"
        val policy: OldPasswordPolicy = PasswordPolicyFactory.createOldPolicy("1-3 a: $password")

        policy.isPasswordValid() shouldBe true
    }
}
