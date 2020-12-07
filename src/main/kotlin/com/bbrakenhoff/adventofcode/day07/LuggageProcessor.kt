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
}
