package com.bbrakenhoff.adventofcode.day11

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SeatTest {

    private fun createFloor(): Seat = Seat(SeatPosition(2, 2), '.')

    private fun createEmptySeat(): Seat = Seat(SeatPosition(2, 2), 'L')

    private fun createOccupiedSeat(): Seat = Seat(SeatPosition(2, 2), '#')

    @Test
    fun `isSeat should be false when seat is actually floor`() {
        val floor: Seat = createFloor()
        floor.isSeat shouldBe false
    }

    @Test
    fun `isSeat should be true when seat is empty`() {
        val emptySeat: Seat = createEmptySeat()
        emptySeat.isSeat shouldBe true
    }

    @Test
    fun `isSeat should be true when seat is occupied`() {
        val occupiedSeat: Seat = createOccupiedSeat()
        occupiedSeat.isSeat shouldBe true
    }

    @Test
    fun `isFloor should be true when seat is actually floor`() {
        val floor: Seat = createFloor()
        floor.isFloor shouldBe true
    }

    @Test
    fun `isFloor should be false when seat is empty`() {
        val emptySeat: Seat = createEmptySeat()
        emptySeat.isFloor shouldBe false
    }

    @Test
    fun `isFloor should be false when seat is occupied`() {
        val occupiedSeat: Seat = createOccupiedSeat()
        occupiedSeat.isFloor shouldBe false
    }

    @Test
    fun `isOccupied should be false when seat is actually floor`() {
        val floor: Seat = createFloor()
        floor.isOccupied shouldBe false
    }

    @Test
    fun `isOccupied should false when seat is empty`() {
        val emptySeat: Seat = createEmptySeat()
        emptySeat.isOccupied shouldBe false
    }

    @Test
    fun `isOccupied should true when seat is occupied`() {
        val occupiedSeat: Seat = createOccupiedSeat()
        occupiedSeat.isOccupied shouldBe true
    }
}
