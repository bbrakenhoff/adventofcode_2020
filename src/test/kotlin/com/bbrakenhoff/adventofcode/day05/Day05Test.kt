package com.bbrakenhoff.adventofcode.day05

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day05Test {

    private lateinit var day05: Day05

    @BeforeEach
    fun beforeEach() {
        day05 = Day05()
    }

    @Test
    fun `solution part one`() {
        val expectedResult: String = "210"
        val result: String = day05.partOne()
        result shouldBe expectedResult
    }

    @Test
    fun `solution part two`() {
        val expectedResult: String = "131"
        val result: String = day05.partTwo()
        result shouldBe expectedResult
    }
}
