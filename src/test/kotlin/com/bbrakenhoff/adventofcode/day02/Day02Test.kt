package com.bbrakenhoff.adventofcode.day02

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day02Test {

    private lateinit var day02: Day02

    @BeforeEach
    fun beforeEach() {
        day02 = Day02()
    }

    @Test
    fun `solution part one`() {
        val expectedResult = "572"
        val result = day02.partOne()
        result shouldBe expectedResult
    }

    @Test
    fun `solution part two`() {
        val expectedResult = ""
        val result = day02.partTwo()
        result shouldBe expectedResult
    }
}