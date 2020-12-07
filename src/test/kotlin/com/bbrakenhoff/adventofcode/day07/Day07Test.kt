package com.bbrakenhoff.adventofcode.day06

import com.bbrakenhoff.adventofcode.day07.Day07
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day07Test {

    private lateinit var day07: Day07

    @BeforeEach
    fun beforeEach() {
        day07 = Day07()
    }

    @Test
    fun `solution part one`() {
        val expectedResult: String = ""
        val result: String = day07.partOne()
        result shouldBe expectedResult
    }

    @Test
    fun `solution part two`() {
        val expectedResult: String = ""
        val result: String = day07.partTwo()
        result shouldBe expectedResult
    }
}
