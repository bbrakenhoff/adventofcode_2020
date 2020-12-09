package com.bbrakenhoff.adventofcode.day02

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day02Test {

    private lateinit var day02: Day02

    @BeforeEach
    fun beforeEach() {
        day02 = Day02()
    }

    @Test
    fun `solution part one`() {
        day02.partOne() shouldBe "572"
    }

    @Test
    fun `solution part two`() {
        day02.partTwo() shouldBe "306"
    }
}