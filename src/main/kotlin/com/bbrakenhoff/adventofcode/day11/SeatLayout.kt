package com.bbrakenhoff.adventofcode.day11

class SeatLayout(private var seatLayout: MutableList<String>) {

    fun mapToSeats(layout: List<String>): List<List<Seat>> = layout.mapIndexed { y: Int, line: String ->
        line.mapIndexed { x: Int, c: Char ->
            Seat(SeatPosition(x, y), c)
        }
    }

    fun findFinalSeatLayout(): List<String> {

        var seatsShuffledCount = -1

        while (seatsShuffledCount != 0) {
            seatsShuffledCount = shuffleSeats()
        }

        return seatLayout
    }

    fun findFinalSeatLayout2(): List<String> {
        var seatsShuffledCount = -1

        while (seatsShuffledCount != 0) {
            seatsShuffledCount = shuffleSeats2()
        }

        return seatLayout
    }

    private fun print(layout: List<String> = seatLayout) {
        println("-----------")
        layout.forEach { println(it) }
        println("-----------")
    }

    private fun seatsToLayout(seats: List<List<Seat>>) = seats.map { row: List<Seat> -> row.joinToString(separator = "") { it.char.toString() } }

    /**
     * Returns number of seats shuffled
     */
    private fun shuffleSeats(): Int {
        var shuffledSeatsCount = 0

        val old = seatLayout.toList()

        println("Before")
        print(old)

        val seats = mapToSeats(old)
        seats.forEach { row: List<Seat> ->
            row.forEach { seat: Seat ->
                if (!seat.isFloor) {
                    val adjacentSeats: List<Seat> = findAdjacentSeats(seat, seats)

                    if (!seat.isOccupied && adjacentSeats.none { it.isOccupied }) {
                        shuffledSeatsCount++ //                        findSeat(seat.position, seats).occupy()
                        val rowCharArray = seatLayout[seat.position.row].toCharArray()
                        rowCharArray[seat.position.column] = '#'
                        seatLayout[seat.position.row] = String(rowCharArray)
                    } else if (seat.isOccupied && adjacentSeats.count { it.isOccupied } >= 4) { //                            replaceSeat(x, y, 'L')
                        shuffledSeatsCount++ //                        findSeat(seat.position, seats).clear()
                        val rowCharArray = seatLayout[seat.position.row].toCharArray()
                        rowCharArray[seat.position.column] = 'L'
                        seatLayout[seat.position.row] = String(rowCharArray)
                        println("Pizzaa pizza!!!! ${seat.char == '#'} ")
                    }
                }
            }
        }

        println("shuffleSeats after!")
        print(seatLayout)
        return shuffledSeatsCount
    }

    private fun shuffleSeats2(): Int {
        var shuffledSeatsCount = 0

        val old = seatLayout.toList()

        val seats = mapToSeats(old)
        seats.forEach { row: List<Seat> ->
            row.forEach { seat: Seat ->
                if (!seat.isFloor) {
                    val adjacentSeats: List<Seat> = findAdjacentSeats2(seat, seats)

                    if (!seat.isOccupied && adjacentSeats.none { it.isOccupied }) {
                        shuffledSeatsCount++ //                        findSeat(seat.position, seats).occupy()
                        val rowCharArray = seatLayout[seat.position.row].toCharArray()
                        rowCharArray[seat.position.column] = '#'
                        seatLayout[seat.position.row] = String(rowCharArray)
                    } else if (seat.isOccupied && adjacentSeats.count { it.isOccupied } >= 5) { //                            replaceSeat(x, y, 'L')
                        shuffledSeatsCount++ //                        findSeat(seat.position, seats).clear()
                        val rowCharArray = seatLayout[seat.position.row].toCharArray()
                        rowCharArray[seat.position.column] = 'L'
                        seatLayout[seat.position.row] = String(rowCharArray)
                    }
                }
            }
        }

        return shuffledSeatsCount
    }

    private fun findSeat(position: SeatPosition, s: List<List<Seat>>): Seat = s[position.row][position.column]

    private fun findAdjacentSeats(currentPosition: Seat, s: List<List<Seat>>): List<Seat> { // seat above
        val adjacentPositions: List<SeatPosition> =
            listOf(currentPosition.positionTop(),
                currentPosition.positionRightTop(),
                currentPosition.positionRight(),
                currentPosition.positionRightBottom(),
                currentPosition.positionBottom(),
                currentPosition.positionLeftBottom(),
                currentPosition.positionLeft(),
                currentPosition.positionLeftTop())

        val filtered = adjacentPositions.filter {
            it.column >= 0 && it.column < seatLayout.first().length && it.row >= 0 && it.row < seatLayout.size
        }

        val mapped = filtered.map { findSeat(it, s) }
        val onlyseats = mapped.filter { !it.isFloor }
        return onlyseats
    }

    private fun findAdjacentSeats2(currentPosition: Seat, s: List<List<Seat>>): List<Seat> {
        val adj: MutableList<Seat> = mutableListOf()

        // find seats top
        adj.addAll(findFloorInDirection(currentPosition, s, 0, -1))
        // find seats right top
        adj.addAll(findFloorInDirection(currentPosition, s, 1, -1))
        // find seats right
        adj.addAll(findFloorInDirection(currentPosition, s, 1, 0))
        // find bottom right
        adj.addAll(findFloorInDirection(currentPosition, s, 1, 1))
        // find bottom
        adj.addAll(findFloorInDirection(currentPosition, s, 0, 1))
        // find left bottom
        adj.addAll(findFloorInDirection(currentPosition, s, -1, 1))
        // find left
        adj.addAll(findFloorInDirection(currentPosition, s, -1, 0))
        // find left top
        adj.addAll(findFloorInDirection(currentPosition, s, -1, -1))

        return adj
    }

    private fun findFloorInDirection(currentPosition: Seat, s: List<List<Seat>>, xoperation: Int, yoperation: Int): List<Seat> {
        var x = currentPosition.position.column
        var y = currentPosition.position.row

        x += xoperation
        y += yoperation

        while (x >= 0 && x < s.first().size && y >= 0 && y < s.size && s[y][x].isFloor) {
            x += xoperation
            y += yoperation
        }

        return if (x >= 0 && x < s.first().size && y >= 0 && y < s.size) {
            listOf(s[y][x])
        } else {
            listOf()
        }
    }
}
