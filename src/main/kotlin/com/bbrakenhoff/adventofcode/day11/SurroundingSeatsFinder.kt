package com.bbrakenhoff.adventofcode.day11

class SurroundingSeatsFinder : AdjacentSeatsFinder() {

    override fun findAdjacentSeats(
        seat: Seat,
        seatLayout: List<List<Seat>>
    ): List<Seat> {
        val currentPosition: SeatPosition = seat.position
        val adjacentPositions: List<SeatPosition> =
            findAdjacentPositions(currentPosition)

        val adjacentPositionsWithinBounds: List<SeatPosition> =
            adjacentPositions.filter {
                positionWithinBounds(it, seatLayout)
            }

        val adjacentSeats: List<Seat> = adjacentPositionsWithinBounds.map {
            findSeatAtPosition(
                it,
                seatLayout
            )
        }

        return adjacentSeats.filter { it.isSeat }
    }

    private fun findAdjacentPositions(currentPosition: SeatPosition) =
        listOf(
            // top
            SeatPosition(currentPosition.x, currentPosition.y - 1),
            // top right
            SeatPosition(currentPosition.x + 1, currentPosition.y - 1),
            // right
            SeatPosition(currentPosition.x + 1, currentPosition.y),
            // bottom right
            SeatPosition(currentPosition.x + 1, currentPosition.y + 1),
            // bottom
            SeatPosition(currentPosition.x, currentPosition.y + 1),
            // bottom left
            SeatPosition(currentPosition.x - 1, currentPosition.y + 1),
            // left
            SeatPosition(currentPosition.x - 1, currentPosition.y),
            // top left
            SeatPosition(currentPosition.x - 1, currentPosition.y - 1)
        )

    private fun findSeatAtPosition(
        position: SeatPosition,
        seatLayout: List<List<Seat>>
    ): Seat = seatLayout[position.y][position.x]
}
