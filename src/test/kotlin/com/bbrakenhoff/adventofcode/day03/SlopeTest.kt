package com.bbrakenhoff.adventofcode.day03

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SlopeTest {

    @Test
    fun `should count all trees passed walking down the slope`() {
        val slopeMap: List<String> =
            listOf("..##.......", "#...#...#..", ".#....#..#.", "..#.#...#.#", ".#...##..#.", "..#.##.....", ".#.#.#....#", ".#........#", "#.##...#...",
                "#...##....#", ".#..#...#.#")

        val slope = Slope(slopeMap, 3, 1)

            slope.countTreesInSlope() shouldBe 7
    }
}
