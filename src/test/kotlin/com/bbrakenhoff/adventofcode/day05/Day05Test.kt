package com.bbrakenhoff.adventofcode.day05

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day05Test {

    private lateinit var day05: Day05

    @BeforeEach
    fun beforeEach() {
        day05 = Day05()
    }

    @Test
    fun `solution part one`() {
        day05.partOne() shouldBe "855"
    }

    @Test
    fun `solution part two`() {
        day05.partTwo() shouldBe "552"
    }
}
