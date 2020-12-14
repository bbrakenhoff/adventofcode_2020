package com.bbrakenhoff.adventofcode.day10

class JoltageAdapters(outputJoltage: List<Int>) {

    private val highestRatedAdapter: Int = outputJoltage.max() ?: 0 + 3
    private val outputJoltage: List<Int> = listOf(0) + outputJoltage.sorted() + listOf(highestRatedAdapter)

    /**
     * Finds the jolt ratings in a Pair, where first value is jolt rating 1 and second is jolt rating 2
     */
    fun findJoltRatings(): Pair<Int, Int> {
        val joltageAdapters: List<Pair<Int, Int>> = findJoltageAdapters()
        val joltageRating1: Int = joltageAdapters.count { it.second - it.first == 1 }
        val joltageRating3: Int = joltageAdapters.count { it.second - it.first == 3 }

        return Pair(joltageRating1, joltageRating3)
    }

    private fun findJoltageAdapters(): List<Pair<Int, Int>> = outputJoltage.indices.map {
        mapJoltageToAdapter(it)
    }

    private fun mapJoltageToAdapter(joltageIndex: Int): Pair<Int, Int> {
        val joltage: Int = outputJoltage[joltageIndex]
        val adapter: Int = if (joltageIndex == outputJoltage.lastIndex) {
            highestRatedAdapter
        } else {
            val nextJoltage: Int = outputJoltage[joltageIndex + 1]
            findAdapterForNextJoltage(joltage, nextJoltage)
        }

        return Pair(joltage, adapter)
    }

    private fun findAdapterForNextJoltage(joltage: Int, nextJoltage: Int) =
    if (joltage + 1 == nextJoltage) {
        nextJoltage
    } else {
        joltage + 3
    }

    fun findPossibleAdapterArrangments(): Long {
        val possibleArrangements: MutableList<Long> = MutableList(outputJoltage.size) { 0L }
        possibleArrangements[0] = 1L

        outputJoltage.forEachIndexed { i: Int, jolt: Int ->
            if (i > 0 && jolt - outputJoltage[i - 1] <= 3) possibleArrangements[i] += possibleArrangements[i - 1]
            if (i > 1 && jolt - outputJoltage[i - 2] <= 3) possibleArrangements[i] += possibleArrangements[i - 2]
            if (i > 2 && jolt - outputJoltage[i - 3] <= 3) possibleArrangements[i] += possibleArrangements[i - 3]
        }

        return possibleArrangements[possibleArrangements.lastIndex - 1]
    }
}
