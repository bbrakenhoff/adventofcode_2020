package com.bbrakenhoff.adventofcode.day03

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day03Test {

    private lateinit var day03: Day03

    @BeforeEach
    fun beforeEach() {
        day03 = Day03()
    }

    @Test
    fun `solution part one`() {
        day03.partOne() shouldBe "228"
    }

    @Test
    fun `solution part two`() {
        day03.partTwo() shouldBe "6818112000"
    }
}
