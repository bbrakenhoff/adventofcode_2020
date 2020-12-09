package com.bbrakenhoff.adventofcode.day07

data class Bag(private val rule: String) {

    val color: String = BAG_COLOR_REGEX.matchEntire(rule)?.groupValues?.get(1).orEmpty()
    val bagsInside: List<Pair<String, Int>>

    init {
        val canContainOtherBags: Boolean = !rule.contains("no other bags")

        bagsInside = if (canContainOtherBags) {
            mapBagsInside()
        } else {
            listOf()
        }
    }

    private fun mapBagsInside(): List<Pair<String, Int>> {
        val containsRule: String = BAG_CONTENT_REGEX.matchEntire(rule)?.groupValues?.get(1).orEmpty()
        val bagsText: List<String> = containsRule.split(", ")
        val regexResultsBags: List<MatchResult?> = bagsText.map { BAG_REGEX.matchEntire(it) }

        return regexResultsBags.map { mapSingleBagInside(it) }
    }

    private fun mapSingleBagInside(it: MatchResult?): Pair<String, Int> {
        val maxContains: Int = it?.groupValues?.get(1)?.toInt() ?: 0
        val color: String = it?.groupValues?.get(2).orEmpty()

        return Pair(color, maxContains)
    }

    fun canContainBag(bag: String): Boolean {
        return bagsInside.any { it.first == bag }
    }

    companion object {
        private val BAG_COLOR_REGEX: Regex = Regex("(.*) bags contain .*")
        private val BAG_CONTENT_REGEX: Regex = Regex(".* bags contain (.*)\\.")
        private val BAG_REGEX: Regex = Regex("(\\d+) (.*) bag(?:s)?")
    }
}
