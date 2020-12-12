package com.bbrakenhoff.adventofcode.day11

class FirstSeenSeatsFinder : AdjacentSeatsFinder() {
    override fun findAdjacentSeats(
        seat: Seat,
        seatLayout: List<List<Seat>>
    ): List<Seat> {
        val adjacentSeats: MutableList<Seat> = mutableListOf()

        // find seats top
        adjacentSeats.addAll(
            findFloorInDirection(
                seat,
                seatLayout,
                0,
                -1
            )
        )
        // find seats right top
        adjacentSeats.addAll(
            findFloorInDirection(
                seat,
                seatLayout,
                1,
                -1
            )
        )
        // find seats right
        adjacentSeats.addAll(
            findFloorInDirection(
                seat,
                seatLayout,
                1,
                0
            )
        )
        // find bottom right
        adjacentSeats.addAll(
            findFloorInDirection(
                seat,
                seatLayout,
                1,
                1
            )
        )
        // find bottom
        adjacentSeats.addAll(
            findFloorInDirection(
                seat,
                seatLayout,
                0,
                1
            )
        )
        // find left bottom
        adjacentSeats.addAll(
            findFloorInDirection(
                seat,
                seatLayout,
                -1,
                1
            )
        )
        // find left
        adjacentSeats.addAll(
            findFloorInDirection(
                seat,
                seatLayout,
                -1,
                0
            )
        )
        // find left top
        adjacentSeats.addAll(
            findFloorInDirection(
                seat,
                seatLayout,
                -1,
                -1
            )
        )

        return adjacentSeats
    }

    private fun findFloorInDirection(
        currentSeat: Seat,
        currentSeatLayout: List<List<Seat>>,
        xOperation: Int,
        yOperation: Int
    ): List<Seat> {
        var position = SeatPosition(
            currentSeat.position.x + xOperation,
            currentSeat.position.y + yOperation
        )

        while (positionWithinBounds(
                position,
                currentSeatLayout
            ) && currentSeatLayout[position.y][position.x].isFloor
        ) {
            position =
                SeatPosition(position.x + xOperation, position.y + yOperation)
        }

        return if (positionWithinBounds(position, currentSeatLayout)) {
            listOf(currentSeatLayout[position.y][position.x])
        } else {
            listOf()
        }
    }
}
