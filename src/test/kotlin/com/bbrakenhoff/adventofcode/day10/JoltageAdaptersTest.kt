package com.bbrakenhoff.adventofcode.day10

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class JoltageAdaptersTest {

    private lateinit var joltageAdapters: JoltageAdapters

    @BeforeEach
    fun beforeEach() {
        joltageAdapters = JoltageAdapters(OUTPUT_JOLTS)
    }

    @Test
    fun `should find the joltage ratings`() {
        val joltRatings: Pair<Int, Int> = joltageAdapters.findJoltRatings()
        joltRatings.first shouldBe 22
        joltRatings.second shouldBe 10
    }

    @Test
    fun `should find the number of adapter arrangements`() {
        joltageAdapters.findPossibleAdapterArrangments() shouldBe 19208L
    }

    companion object {

        private val OUTPUT_JOLTS: List<Int> = listOf(
            28,
            33,
            18,
            42,
            31,
            14,
            46,
            20,
            48,
            47,
            24,
            23,
            49,
            45,
            19,
            38,
            39,
            11,
            1,
            32,
            25,
            35,
            8,
            17,
            7,
            9,
            4,
            2,
            34,
            10,
            3
        )
    }
}
