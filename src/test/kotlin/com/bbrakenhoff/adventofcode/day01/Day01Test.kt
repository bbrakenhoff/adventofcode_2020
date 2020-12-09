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
        day01.partOne() shouldBe "866436"
    }

    @Test
    fun `solution part two`() {
        day01.partTwo() shouldBe "276650720"
    }
}
