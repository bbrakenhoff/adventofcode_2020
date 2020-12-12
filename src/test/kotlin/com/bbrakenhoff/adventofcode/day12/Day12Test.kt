package com.bbrakenhoff.adventofcode.day12

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day12Test {

    private lateinit var day12: Day12

    @BeforeEach
    fun beforeEach() {
        day12 = Day12()
    }

    @Test
    fun `solution part one`() {
        day12.partOne() shouldBe "858"
    }

    @Test
    fun `solution part two`() {
        day12.partTwo() shouldBe "39140"
    }
}
