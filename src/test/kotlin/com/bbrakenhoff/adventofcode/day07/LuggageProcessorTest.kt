package com.bbrakenhoff.adventofcode.day07

import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LuggageProcessorTest {

    private lateinit var luggageProcessor: LuggageProcessor

    @BeforeEach
    fun beforeEach() {
        luggageProcessor = LuggageProcessor(RULES)
    }

    @Test
    fun `should find all the bags that can be used to carry given bag`() {
        val usableBags: List<Bag> = luggageProcessor.findBagsToCarry("shiny gold")
        usableBags.shouldContainExactlyInAnyOrder(listOf(Bag(RULES[2]), Bag(RULES[3]), Bag(RULES[1]), Bag(RULES[0])))
    }

    @Test
    fun `should count bags neede to carry given bag`() {
        val neededBags: Int = luggageProcessor.countBagsNeeded("shiny gold") - 1
        neededBags shouldBe 32
    }

    companion object {
        private val RULES: List<String> =
            listOf("light red bags contain 1 bright white bag, 2 muted yellow bags.",
                "dark orange bags contain 3 bright white bags, 4 muted yellow bags.",
                "bright white bags contain 1 shiny gold bag.",
                "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.",
                "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.",
                "dark olive bags contain 3 faded blue bags, 4 dotted black bags.",
                "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.",
                "faded blue bags contain no other bags.",
                "dotted black bags contain no other bags.")
    }
}
