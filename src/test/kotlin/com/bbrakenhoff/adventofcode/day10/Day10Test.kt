package com.bbrakenhoff.adventofcode.day10

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day10Test {
    private lateinit var day10: Day10

    @BeforeEach
    fun beforeEach() {
        day10 = Day10()
    }

    @Test
    fun `solution part one`() {
        day10.partOne() shouldBe ""
    }

    @Test
    fun `solution part two`() {
        day10.partTwo() shouldBe ""
    }
}