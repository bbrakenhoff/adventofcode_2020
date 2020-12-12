package com.bbrakenhoff.adventofcode.day11

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SeatLayoutTest {

    @Test
    fun `should shuffle seats until no changes made anymore using surrounding seats`() {
        val seatLayout: SeatLayout =
            SeatLayout(INITIAL_SEAT_LAYOUT, SurroundingSeatsFinder(), 4)
        seatLayout.findFinalSeatLayout() shouldBe FINAL_SEAT_LAYOUT_USING_SURROUNDING_SEATS
    }

    @Test
    fun `should shuffle seats 2 until no changes made anymore using first seen seats`() {
        val seatLayout: SeatLayout =
            SeatLayout(INITIAL_SEAT_LAYOUT, FirstSeenSeatsFinder(), 5)
        seatLayout.findFinalSeatLayout() shouldBe FINAL_SEAT_LAYOUT_USING_FIRST_SEEN_SEATS
    }

    companion object {
        private val INITIAL_SEAT_LAYOUT: List<String> =
            listOf(
                "L.LL.LL.LL",
                "LLLLLLL.LL",
                "L.L.L..L..",
                "LLLL.LL.LL",
                "L.LL.LL.LL",
                "L.LLLLL.LL",
                "..L.L.....",
                "LLLLLLLLLL",
                "L.LLLLLL.L",
                "L.LLLLL.LL"
            )
        private val FINAL_SEAT_LAYOUT_USING_SURROUNDING_SEATS: List<String> =
            listOf(
                "#.#L.L#.##",
                "#LLL#LL.L#",
                "L.#.L..#..",
                "#L##.##.L#",
                "#.#L.LL.LL",
                "#.#L#L#.##",
                "..L.L.....",
                "#L#L##L#L#",
                "#.LLLLLL.L",
                "#.#L#L#.##"
            )
        private val FINAL_SEAT_LAYOUT_USING_FIRST_SEEN_SEATS: List<String> =
            listOf(
                "#.L#.L#.L#",
                "#LLLLLL.LL",
                "L.L.L..#..",
                "##L#.#L.L#",
                "L.L#.LL.L#",
                "#.LLLL#.LL",
                "..#.L.....",
                "LLL###LLL#",
                "#.LLLLL#.L",
                "#.L#LL#.L#"
            )
    }
}
