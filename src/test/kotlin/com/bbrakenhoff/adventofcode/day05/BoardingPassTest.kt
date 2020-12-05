package com.bbrakenhoff.adventofcode.day05

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class BoardingPassTest {

    @Test
    fun `should find single id`() {
        val text: String = "FBFBBFFRLR"
        val boardingPass = BoardingPass(text)
        val id = boardingPass.findSeatId()

        id shouldBe 357
    }

    @Test
    fun `should find the seat id of a boarding pass`() {
        val boardingPassTextIdMap: Map<String, Int> = mapOf("FBFBBFFRLR" to 357, "BFFFBBFRRR" to 567, "FFFBBBFRRR" to 119, "BBFFBBFRLL" to 820)

        boardingPassTextIdMap.forEach {
            val boardingPass = BoardingPass(it.key)
            val id = boardingPass.findSeatId()
            id shouldBe it.value
        }
    }
}
