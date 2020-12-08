package com.bbrakenhoff.adventofcode.day08

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day08Test {

    private lateinit var day08: Day08

    @BeforeEach
    fun beforeEach() {
        day08 = Day08()
    }

    @Test
    fun `solution part one`() {
        val expectedResult: String = "1489"
        val result: String = day08.partOne()
        result shouldBe expectedResult
    }

    @Test
    fun `solution part two`() {
        val expectedResult: String = ""
        val result: String = day08.partTwo()
        result shouldBe expectedResult
    }
}