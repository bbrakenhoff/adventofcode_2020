package com.bbrakenhoff.adventofcode.day07

import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class BagTest {

    @Test
    fun `should have an empty list of containing bags, when bag cannot contain other bags`() {
        val rule: String = "dull white bags contain no other bags."
        val luggageProcessor = Bag(rule)

        luggageProcessor.bagsInside.shouldBeEmpty()
    }

    @Test
    fun `should have a list of containing bags`() {
        val rule: String = "faded olive bags contain 1 bright crimson bag, 15 dotted green bags, 5 dull bronze bags, 2 posh turquoise bags."
        val luggageProcessor = Bag(rule)

        luggageProcessor.color shouldBe "faded olive"
        luggageProcessor.bagsInside.shouldContainExactlyInAnyOrder(listOf(Pair("bright crimson", 1),
                                                                          Pair("dotted green", 15),
                                                                          Pair("dull bronze", 5),
                                                                          Pair("posh turquoise", 2)))
    }

    @Test
    fun `should return false when no bags can be contained`() {
        val rule: String = "dull white bags contain no other bags."
        val luggageProcessor = Bag(rule)

        luggageProcessor.canContainBag("shiny gold") shouldBe false
    }

    @Test
    fun `should return false when given bag not equal to any of the bags that can be contained`() {
        val rule: String = "faded olive bags contain 12 bright crimson bags, 5 dotted green bags, 5 dull bronze bags, 2 posh turquoise bags."
        val luggageProcessor = Bag(rule)

        luggageProcessor.canContainBag("shiny gold") shouldBe false
    }

    @Test
    fun `should return true when given bag equals one of the bags that can be contained`() {
        val rule: String = "faded olive bags contain 1 bright crimson bag, 15 dotted green bags, 5 dull bronze bags, 2 posh turquoise bags."
        val luggageProcessor = Bag(rule)

        luggageProcessor.canContainBag("posh turquoise") shouldBe true
    }
}
