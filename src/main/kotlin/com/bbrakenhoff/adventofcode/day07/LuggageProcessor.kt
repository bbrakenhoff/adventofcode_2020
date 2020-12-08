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

    fun countBagsNeeded(bagToCarry: String, bagsNeeded: List<Bag> = bags): Int {
        val bagsToCarry: List<Bag> = bagsNeeded.filter { it.color == bagToCarry }
        val bagsInsideBagsToCarry: List<Pair<String, Int>> = bagsToCarry.flatMap { it.bagsInside }
        return 1 + bagsInsideBagsToCarry.map { it.second * countBagsNeeded(it.first) }.sum()
    }
}
