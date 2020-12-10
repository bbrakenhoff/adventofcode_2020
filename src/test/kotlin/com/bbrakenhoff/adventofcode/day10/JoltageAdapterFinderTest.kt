package com.bbrakenhoff.adventofcode.day10

import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class JoltageAdapterFinderTest {

    @Test
    fun `find jolts short list`() {
        val outputJolts: List<Int> = listOf(16, 10, 15, 5, 1, 11, 7, 19, 6, 12, 4)
        val joltageAdapterFinder = JoltageAdapterFinder(outputJolts)
        val outputAdapter: List<Pair<Int, Int>> = joltageAdapterFinder.find()

        // output - adapter
        outputAdapter.shouldContainExactlyInAnyOrder(listOf(Pair(1, 4),
                                                            Pair(4, 5),
                                                            Pair(5, 6),
                                                            Pair(6, 7),
                                                            Pair(7, 10),
                                                            Pair(10, 11),
                                                            Pair(11, 12),
                                                            Pair(12, 15),
                                                            Pair(15, 16),
                                                            Pair(16, 19),
                                                            Pair(19, 22)))
        joltageAdapterFinder.highestRatedAdapter shouldBe 22
        joltageAdapterFinder.differences3Jolt shouldBe 5
        joltageAdapterFinder.differences1Jolt shouldBe 7
    }

    @Test
    fun `find jolts`(){
        val outputJolts:List<Int> = listOf(
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

        val joltageAdapterFinder = JoltageAdapterFinder(outputJolts)
        val outputAdapter: List<Pair<Int, Int>> = joltageAdapterFinder.find()

        joltageAdapterFinder.differences3Jolt shouldBe 10
        joltageAdapterFinder.differences1Jolt shouldBe 22
        joltageAdapterFinder.findPermutationCount() shouldBe 19208L
    }
}