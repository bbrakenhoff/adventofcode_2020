package com.bbrakenhoff.adventofcode.day11

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SeatLayoutTest {

    @Test
    fun `should shuffle seats until no changes made anymore`() {
        val seatLayout: SeatLayout = SeatLayout(INITIAL_SEAT_LAYOUT.toMutableList())
        seatLayout.findFinalSeatPlan() shouldBe FINAL_SEAT_LAYOUT
    }

    companion object {
        private val INITIAL_SEAT_LAYOUT: List<String> =
            listOf("L.LL.LL.LL", "LLLLLLL.LL", "L.L.L..L..", "LLLL.LL.LL", "L.LL.LL.LL", "L.LLLLL.LL", "..L.L.....", "LLLLLLLLLL", "L.LLLLLL.L", "L.LLLLL.LL")
        private val FINAL_SEAT_LAYOUT: List<String> =
            listOf("#.#L.L#.##", "#LLL#LL.L#", "L.#.L..#..", "#L##.##.L#", "#.#L.LL.LL", "#.#L#L#.##", "..L.L.....", "#L#L##L#L#", "#.LLLLLL.L", "#.#L#L#.##")
    }
}
