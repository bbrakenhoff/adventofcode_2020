package com.bbrakenhoff.adventofcode.day11

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SeatTest {

    private fun createFloor(): Seat = Seat(Pair(2, 2), '.')

    private fun createEmptySeat(): Seat = Seat(Pair(2, 2), 'L')

    private fun createOccupiedSeat(): Seat = Seat(Pair(2, 2), '#')

    @Test
    fun `should find layout position above`() {
        val seat: Seat = createFloor()
        seat.positionTop() shouldBe Pair(2, 1)
    }

    @Test
    fun `should find layout position below`() {
        val seat: Seat = createFloor()
        seat.positionBottom() shouldBe Pair(2, 3)
    }

    @Test
    fun `should find layout position left`() {
        val seat: Seat = createFloor()
        seat.positionLeft() shouldBe Pair(1, 2)
    }

    @Test
    fun `should find layout position right`() {
        val seat: Seat = createFloor()
        seat.positionRight() shouldBe Pair(3, 2)
    }

    @Test
    fun `should find layout position left top corner`() {
        val seat: Seat = createFloor()
        seat.positionLeftTop() shouldBe Pair(1, 1)
    }

    @Test
    fun `should find layout position right top corner`() {
        val seat: Seat = createFloor()
        seat.positionRightTop() shouldBe Pair(3, 1)
    }

    @Test
    fun `should find layout position right bottom`() {
        val seat: Seat = createFloor()
        seat.positionRightBottom() shouldBe Pair(3, 3)
    }

    @Test
    fun `should find layout position left bottom`() {
        val seat: Seat = createFloor()
        seat.positionLeftBottom() shouldBe Pair(1, 3)
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
    fun `seatIsOccupied should be false when seat is actually floor`() {
        val floor: Seat = createFloor()
        floor.isOccupied shouldBe false
    }

    @Test
    fun `seatIsOccupied should false when seat is empty`() {
        val emptySeat: Seat = createEmptySeat()
        emptySeat.isOccupied shouldBe false
    }

    @Test
    fun `seatIsOccupied should true when seat is occupied`() {
        val occupiedSeat: Seat = createOccupiedSeat()
        occupiedSeat.isOccupied shouldBe true
    }

    @Test
    fun `should do nothing when clearing and layout position is floor`() {
        val floor: Seat = createFloor()
        floor.clear()

        floor.isFloor shouldBe true
        floor.isOccupied shouldBe false
    }

    @Test
    fun `should do nothing when clearing an empty seat`() {
        val emptySeat: Seat = createEmptySeat()
        emptySeat.clear()

        emptySeat.isFloor shouldBe false
        emptySeat.isOccupied shouldBe false
    }

    @Test
    fun `should clear an occupied seat`() {
        val occupiedSeat: Seat = createOccupiedSeat()
        occupiedSeat.clear()

        occupiedSeat.isFloor shouldBe false
        occupiedSeat.isOccupied shouldBe false
    }

    @Test
    fun `should do nothing when occupy and seat is actually floor`() {
        val floor: Seat = createFloor()
        floor.occupy()

        floor.isFloor shouldBe true
        floor.isOccupied shouldBe false
    }

    @Test
    fun `should do nothing when occupying an occupied seat`() {
        val occupiedSeat: Seat = createOccupiedSeat()
        occupiedSeat.occupy()

        occupiedSeat.isFloor shouldBe false
        occupiedSeat.isOccupied shouldBe true
    }

    @Test
    fun `should occupy an empty seat`() {
        val emptySeat: Seat = createEmptySeat()
        emptySeat.occupy()

        emptySeat.isFloor shouldBe false
        emptySeat.isOccupied shouldBe true
    }
}