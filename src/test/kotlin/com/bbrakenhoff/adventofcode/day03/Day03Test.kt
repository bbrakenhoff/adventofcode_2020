package com.bbrakenhoff.adventofcode.day03

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day03Test {

    private lateinit var day03: Day03

    @BeforeEach
    fun beforeEach() {
        day03 = Day03()
    }

    @Test
    fun `solution part one`() {
        val expectedResult: String = "228"
        val result: String = day03.partOne()
        result shouldBe expectedResult
    }

    @Test
    fun `solution part two`() {
        val expectedResult: String = "6818112000L"
        val result: String = day03.partTwo()
        result shouldBe expectedResult
    }
}