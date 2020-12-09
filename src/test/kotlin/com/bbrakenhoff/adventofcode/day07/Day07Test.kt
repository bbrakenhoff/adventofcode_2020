package com.bbrakenhoff.adventofcode.day07

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day07Test {

    private lateinit var day07: Day07

    @BeforeEach
    fun beforeEach() {
        day07 = Day07()
    }

    @Test
    fun `solution part one`() {
        day07.partOne() shouldBe "261"
    }

    @Test
    fun `solution part two`() {
        day07.partTwo() shouldBe "3765"
    }
}
