package com.bbrakenhoff.adventofcode.day01

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day01Test {

    private lateinit var day01: Day01

    @BeforeEach
    fun beforeEach() {
        day01 = Day01()
    }

    @Test
    fun `solution part one`() {
        val expectedResult = "866436"
        val result = day01.partOne()
        result shouldBe expectedResult
    }

    @Test
    fun `solution part two`() {
        val expectedResult = "276650720"
        val result = day01.partTwo()
        result shouldBe expectedResult
    }
}