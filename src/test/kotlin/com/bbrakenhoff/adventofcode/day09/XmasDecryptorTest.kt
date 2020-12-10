package com.bbrakenhoff.adventofcode.day09

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class XmasDecryptorTest {

    private lateinit var xmasDecryptor: XmasDecryptor

    @BeforeEach
    fun beforeEach() {
        xmasDecryptor = XmasDecryptor(NUMBERS, PREAMBLE)
    }

    @Test
    fun `should return the first invalid number that does not comply with the sum rule`() {
        xmasDecryptor.findFirstInvalidNumber() shouldBe 127
    }

    @Test
    fun `should return the encryption weakness`() {
        xmasDecryptor.findEncryptionWeakness() shouldBe 62L
    }

    companion object {
        private val NUMBERS: List<Long> = listOf(35, 20, 15, 25, 47, 40, 62, 55, 65, 95, 102, 117, 150, 182, 127, 219, 299, 277, 309, 576)
        private const val PREAMBLE: Int = 5
    }
}
