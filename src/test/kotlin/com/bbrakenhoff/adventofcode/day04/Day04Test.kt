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
        day04.partOne() shouldBe "210"
    }

    @Test
    fun `solution part two`() {
        day04.partTwo() shouldBe "131"
    }
}
