package com.bbrakenhoff.adventofcode.day09

import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class XmasDecryptorTest {

    @Test
    fun `should return the first number that does not match the sum rule`() {
        val numbers: List<Long> = listOf(35, 20, 15, 25, 47, 40, 62, 55, 65, 95, 102, 117, 150, 182, 127, 219, 299, 277, 309, 576)
        val preambleLength: Int = 5
        val xmasDecryptor: XmasDecryptor = XmasDecryptor(numbers, preambleLength)

        xmasDecryptor.findFirstError() shouldBe 127
    }

    @Test
    fun `should return the encryption weakness`() {
        val numbers: List<Long> = listOf(35, 20, 15, 25, 47, 40, 62, 55, 65, 95, 102, 117, 150, 182, 127, 219, 299, 277, 309, 576)
        val preambleLength: Int = 5

        val xmasDecryptor: XmasDecryptor = XmasDecryptor(numbers, preambleLength)
        val sum = xmasDecryptor.findSumFirstError()
        sum shouldBe 62L
    }
}