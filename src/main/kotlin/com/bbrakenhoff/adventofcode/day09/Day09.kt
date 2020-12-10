package com.bbrakenhoff.adventofcode.day09

import com.bbrakenhoff.adventofcode.Day
import com.bbrakenhoff.adventofcode.PuzzleInputReader

class Day09 : Day {

    override val enabledFocusedPrint: Boolean = true

    private val numbers: List<Long> = PuzzleInputReader.read(9).map { it.toLong() }
    private val xmasDecryptor: XmasDecryptor = XmasDecryptor(numbers, 25)

    override fun partOne(): String {
        val firstError = xmasDecryptor.findFirstInvalidNumber()
        return "$firstError"
    }

    override fun partTwo(): String {
        val encryptionWeakness = xmasDecryptor.findEncryptionWeakness()
        return "$encryptionWeakness"
    }
}
