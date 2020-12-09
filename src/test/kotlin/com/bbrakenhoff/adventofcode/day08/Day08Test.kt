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
        day08.partOne() shouldBe "1489"
    }

    @Test
    fun `solution part two`() {
        day08.partTwo() shouldBe "1539"
    }
}