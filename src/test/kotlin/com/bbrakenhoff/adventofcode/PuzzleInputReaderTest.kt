package com.bbrakenhoff.adventofcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class PuzzleInputReaderTest {

    @Test
    fun `should read all lines from file in puzzle-input folder text file with day name`() {
        val expectedList: List<String> =
            listOf("Why was this puzzle so easy / hard?",
                   "The difficulty and subject matter varies throughout each event.",
                   "",
                   "Why do the puzzles unlock at midnight EST/UTC-5?",
                   "Because that's when I can consistently be available to make sure everything is working.",
                   "",
                   "How does authentication work?",
                   "Advent of Code uses OAuth to confirm your identity through other services.",
                   "",
                   "I find the text on the site hard to read. Is there a high contrast mode?",
                   "There is a high contrast alternate stylesheet.",
                   "",
                   "I have a puzzle idea! Can I send it to you?",
                   "Please don't.")

        PuzzleInputReader.read(0) shouldBe expectedList
    }

    @Test
    fun `should create list of lists with all lines separated by blank lines`() {
        val expectedList: List<List<String>> =
            listOf(listOf("Why was this puzzle so easy / hard?", "The difficulty and subject matter varies throughout each event."),
                   listOf("Why do the puzzles unlock at midnight EST/UTC-5?",
                          "Because that's when I can consistently be available to make sure everything is working."),
                   listOf("How does authentication work?", "Advent of Code uses OAuth to confirm your identity through other services."),
                   listOf("I find the text on the site hard to read. Is there a high contrast mode?", "There is a high contrast alternate stylesheet."),
                   listOf("I have a puzzle idea! Can I send it to you?", "Please don't."))

        val puzzleInput: List<String> = PuzzleInputReader.read(0)
        PuzzleInputReader.groupByBlankLines(puzzleInput) shouldBe expectedList
    }
}
