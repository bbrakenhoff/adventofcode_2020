package com.bbrakenhoff.adventofcode.day06

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day06Test {

    private lateinit var day06: Day06

    @BeforeEach
    fun beforeEach() {
        day06 = Day06()
    }

    @Test
    fun `solution part one`() {
        day06.partOne() shouldBe "6534"
    }

    @Test
    fun `solution part two`() {
        day06.partTwo() shouldBe "3402"
    }
}
