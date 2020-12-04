package com.bbrakenhoff.adventofcode.day04

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day04Test {

    private lateinit var day04: Day04

    @BeforeEach
    fun beforeEach() {
        day04 = Day04()
    }

    @Test
    fun `solution part one`() {
        val expectedResult: String = ""
        val result: String = day04.partOne()
        result shouldBe expectedResult
    }

    @Test
    fun `solution part two`() {
        val expectedResult: String = ""
        val result: String = day04.partTwo()
        result shouldBe expectedResult
    }
}