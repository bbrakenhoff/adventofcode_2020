package com.bbrakenhoff.adventofcode.day06

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CustomsDeclarationGroupTest {

    private lateinit var customsDeclarationGroup:CustomsDeclarationGroup

    @BeforeEach
    fun beforeEach(){
        val groupAnswers: List<String> = listOf("abcx", "abcy", "abcz")
        customsDeclarationGroup= CustomsDeclarationGroup(groupAnswers)
    }

    @Test
    fun `should count the answers that have been answered with 'yes'`() {
        val count = customsDeclarationGroup.countAllYesAnswers()
        count shouldBe 6
    }

    @Test
    fun `should count the answers everyone answered with 'yes'`(){
        val count = customsDeclarationGroup.countUnanimouslyYesAnswers()
        count shouldBe 3
    }
}
