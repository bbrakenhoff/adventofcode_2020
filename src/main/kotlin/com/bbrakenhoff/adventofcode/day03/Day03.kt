package com.bbrakenhoff.adventofcode.day03

import com.bbrakenhoff.adventofcode.Day
import com.bbrakenhoff.adventofcode.PuzzleInputReader

class Day03() : Day {

    override val enabledFocusedPrint: Boolean = true

    private val slopeMap: List<String> = PuzzleInputReader.read(3)

    override fun partOne(): String {
        val treeCount = Slope(slopeMap, 3, 1).countTreesInSlope()
        return "$treeCount"
    }

    override fun partTwo(): String {
        val slopeRight1Down1 = Slope(slopeMap, 1, 1)
        val slopeRight3Down1 = Slope(slopeMap, 3, 1)
        val slopeRight5Down1 = Slope(slopeMap, 5, 1)
        val slopeRight7Down1 = Slope(slopeMap, 7, 1)
        val slopeRight1Down2 = Slope(slopeMap, 1, 2)

        println("slopeRight1Down1 ${slopeRight1Down1.countTreesInSlope()}")
        println("slopeRight3Down1 ${slopeRight3Down1.countTreesInSlope()}")
        println("slopeRight5Down1 ${slopeRight5Down1.countTreesInSlope()}")
        println("slopeRight7Down1 ${slopeRight7Down1.countTreesInSlope()}")
        println("slopeRight1Down2 ${slopeRight1Down2.countTreesInSlope()}")

        val allSlopes: List<Slope> = listOf(slopeRight1Down1, slopeRight3Down1, slopeRight5Down1, slopeRight7Down1, slopeRight1Down2)
        val countedTrees: List<Long> = allSlopes.map { it.countTreesInSlope() }

        val product: Long = countedTrees.fold(1, { total: Long, countedTreesOnSlope: Long -> total * countedTreesOnSlope })
        return "$product"
    }
}
