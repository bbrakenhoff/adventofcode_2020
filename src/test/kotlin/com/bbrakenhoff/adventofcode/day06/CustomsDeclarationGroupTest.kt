package com.bbrakenhoff.adventofcode.day06

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class CustomsDeclarationGroupTest {

    @Test
    fun `should count the answers that have been answered with 'yes'`() {
        val groupAnswers: List<String> = listOf("abcx", "abcy", "abcz")

        val customsDeclarationGroup: CustomsDeclarationGroup = CustomsDeclarationGroup(groupAnswers)
        val count = customsDeclarationGroup.countYesAnswers()
        count shouldBe 6
    }
}
