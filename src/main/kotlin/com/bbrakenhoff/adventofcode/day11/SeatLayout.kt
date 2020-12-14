package com.bbrakenhoff.adventofcode.day11

class SeatLayout(initialSeatLayout: List<String>, private val adjacentSeatsFinder: AdjacentSeatsFinder, private val maxNearbyOccupiedSeats: Int) {

    private val editedSeatLayout: MutableList<String> = initialSeatLayout.toMutableList()

    fun findFinalSeatLayout(): List<List<Seat>> {
        var shuffledSeatsCount = -1

        while (shuffledSeatsCount != 0) {
            shuffledSeatsCount = shuffleSeats()
        }

        return mapEditedSeatLayoutToSeats()
    }

    /**
     * Returns number of seats shuffled
     */
    private fun shuffleSeats(): Int {
        val seats: List<List<Seat>> = mapEditedSeatLayoutToSeats()
        var countShuffledSeats: Int = 0

        seats.forEach { row: List<Seat> ->
            countShuffledSeats += shuffleSeatsInRow(row, seats)
        }

        return countShuffledSeats
    }

    private fun mapEditedSeatLayoutToSeats(): List<List<Seat>> = editedSeatLayout.mapIndexed { y: Int, line: String ->
        line.mapIndexed { x: Int, c: Char ->
            Seat(SeatPosition(x, y), c)
        }
    }

    private fun shuffleSeatsInRow(row: List<Seat>, seats: List<List<Seat>>): Int {
        var countShuffledSeats: Int = 0

        row.filter { it.isSeat }.forEach {
            val adjacentSeats: List<Seat> = adjacentSeatsFinder.findAdjacentSeats(it, seats)

            if (shouldOccupySeat(it, adjacentSeats)) {
                countShuffledSeats++ //                        findSeat(seat.position, seats).occupy()
                shuffleSeat(it, Seat.OCCUPIED_SEAT_CHAR)
            } else if (shouldEmptySeat(it, adjacentSeats)) {
                countShuffledSeats++
                shuffleSeat(it, Seat.EMPTY_SEAT_CHAR)
            }
        }

        return countShuffledSeats
    }

    private fun shouldOccupySeat(seat: Seat, adjacentSeats: List<Seat>): Boolean = !seat.isOccupied && adjacentSeats.none { it.isOccupied }

    private fun shuffleSeat(seat: Seat, newSeatChar: Char) {
        val rowCharArray = editedSeatLayout[seat.position.y].toCharArray()
        rowCharArray[seat.position.x] = newSeatChar
        editedSeatLayout[seat.position.y] = String(rowCharArray)
    }

    private fun shouldEmptySeat(seat: Seat, adjacentSeats: List<Seat>): Boolean =
        seat.isOccupied && adjacentSeats.count { it.isOccupied } >= maxNearbyOccupiedSeats
}
