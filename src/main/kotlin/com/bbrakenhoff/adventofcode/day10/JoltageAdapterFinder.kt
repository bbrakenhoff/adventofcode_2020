package com.bbrakenhoff.adventofcode.day10

class JoltageAdapterFinder(outputJoltage: List<Int>) {

    var differences3Jolt: Int = 0
    var differences1Jolt: Int = 0

    private val outputJoltage: List<Int> = outputJoltage.sorted()
    val highestRatedAdapter: Int
        get() = 3 + outputJoltage.max()!!

    private val expected =
        listOf(Pair(1, 4), Pair(4, 5), Pair(5, 6), Pair(6, 7), Pair(7, 10), Pair(10, 11), Pair(11, 12), Pair(12, 15), Pair(15, 16), Pair(16, 19), Pair(19, 22))

    fun find(): List<Pair<Int, Int>> {
        val result = outputJoltage.mapIndexed { i: Int, joltage: Int ->
            var adapter = 0

            adapter = if (i == outputJoltage.lastIndex) {
                highestRatedAdapter
            } else {
                val nextJoltage: Int = outputJoltage[i + 1]
                if (joltage + 1 == nextJoltage || joltage + 3 == nextJoltage) {
                    nextJoltage
                } else {
                    joltage + 3
                }
            }
            Pair(joltage, adapter)
        }
        println("expected: $expected")
        println("calculat: $result")
        println("hgihest rated adapter: $highestRatedAdapter")
        findJoltDifferences(result)
        return result
    }

    private fun findJoltDifferences(foundAdapters: List<Pair<Int, Int>>) {
        differences1Jolt = 1 + foundAdapters.count { it.second - it.first == 1 }
        differences3Jolt = foundAdapters.count { it.second - it.first == 3 }
    }

    fun findPermutationCount(): Long {
        val joltsIncl0andHighest = listOf(0) + outputJoltage + highestRatedAdapter
        val permutationCount = MutableList(joltsIncl0andHighest.size) { 0L }
        permutationCount[0] = 1L


        joltsIncl0andHighest.forEachIndexed { i, jolt ->
            if (i > 0 && jolt - joltsIncl0andHighest[i - 1] <= 3) permutationCount[i] += permutationCount[i - 1]
            if (i > 1 && jolt - joltsIncl0andHighest[i - 2] <= 3) permutationCount[i] += permutationCount[i - 2]
            if (i > 2 && jolt - joltsIncl0andHighest[i - 3] <= 3) permutationCount[i] += permutationCount[i - 3]
        }

        return permutationCount.last()
    }

    companion object {
        private const val CHARGING_OUTLET: Int = 0 // -> adapter 1, 2, 3 // 1 jolt -> adapter 4
    }
}