package com.bbrakenhoff.adventofcode.day07

class LuggageProcessor(rules: List<String>) {

    private val bags: MutableList<Bag> = rules.map { Bag(it) }.toMutableList()

    fun findBagsToCarry(bagToCarryColor: String, usableBags: MutableList<Bag> = mutableListOf()): List<Bag> {
        val directlyUsableBags: List<Bag> = bags.filter { it.canContainBag(bagToCarryColor) }
        usableBags.addAll(directlyUsableBags)

        directlyUsableBags.forEach {
            findBagsToCarry(it.color, usableBags)
        }

        return usableBags.distinctBy { it.color }
    }

    fun countBagsNeeded(bagToCarry: String, count: Int = 0): Int {
        val bagsWithColorToCarry: MutableList<Bag> = bags.filter { it.color == bagToCarry }.toMutableList()
        val directlyNeededBagsCount: Int = bagsWithColorToCarry.sumBy { it.countBagsInside() }
        val newCount = count + directlyNeededBagsCount

        val bagsInside: List<Pair<Int, String>> = bagsWithColorToCarry.filter { it.bagsInside.isNotEmpty() }.flatMap { it.bagsInside }
        println("countBagsNeeded: $bagToCarry, $count $bagsInside")
        bagsInside.forEach {
            countBagsNeeded(it.second, newCount)
        }

        return newCount
    }
}
