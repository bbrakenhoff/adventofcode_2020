package com.bbrakenhoff.adventofcode.day09

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day09Test {

    private lateinit var day09: Day09

    @BeforeEach
    fun beforeEach() {
        day09 = Day09()
    }

    @Test
    fun `solution part one`() {
        day09.partOne() shouldBe "776203571"
    }

    @Test
    fun `solution part two`() {
        day09.partTwo() shouldBe "104800569"
    }
}
