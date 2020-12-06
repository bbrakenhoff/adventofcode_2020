package com.bbrakenhoff.adventofcode.day06

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day06Test {

    private lateinit var day06:Day06

    @BeforeEach
    fun beforeEach(){
        day06=Day06()
    }

    @Test
    fun `solution part one`() {
        val expectedResult: String = "855"
        val result: String = day06.partOne()
        result shouldBe expectedResult
    }

    @Test
    fun `solution part two`() {
        val expectedResult: String = "552"
        val result: String = day06.partTwo()
        result shouldBe expectedResult
    }
}
