package com.bbrakenhoff.adventofcode.day11

class SeatLayout(private var seatLayout: MutableList<String>) {

    private fun mapToSeats(layout: List<String>) = layout.mapIndexed { y: Int, line: String ->
        line.mapIndexed { x: Int, c: Char ->
            Seat(x to y, c)
        }
    }

    fun findFinalSeatPlan(): List<String> {
        print()
        var count: Int = shuffleSeats()
        println("count $count")
        print()

        count = shuffleSeats()
        println("count $count")
        print()

        count = shuffleSeats()
        println("count $count")
        print()

        count = shuffleSeats()
        println("count $count")
        print()

        count = shuffleSeats()
        println("count $count")
        print()

        count = shuffleSeats()
        println("count $count")
        print()

        return seatLayout
    }

    private fun print() {
        println("-----------")
        seatLayout.forEach { println(it) }
        println("-----------")
    }

    private fun seatsToLayout(seats: List<List<Seat>>) = seats.map { row: List<Seat> -> row.joinToString(separator = "") { it.char.toString() } }

    /**
     * Returns number of seats shuffled
     */
    private fun shuffleSeats(): Int {
        var shuffledSeatsCount = 0

        val old = seatLayout.toList()
        val seats = mapToSeats(seatLayout)
        println("shuffleSeats before! ${seatsToLayout(seats) == seatLayout}")
        seats.forEach { row: List<Seat> ->
            row.forEach { seat: Seat ->
                if (!seat.isFloor) {
                    val adjacentSeats: List<Seat> = findAdjacentSeats(seat, seats)

                    if (!seat.isOccupied && adjacentSeats.none { it.isOccupied }) {
                        shuffledSeatsCount++ //                        findSeat(seat.position, seats).occupy()
                        val rowCharArray = seatLayout[seat.position.second].toCharArray()
                        rowCharArray[seat.position.first] = '#'
                        seatLayout[seat.position.second] = String(rowCharArray)
                    } else if (seat.isOccupied && adjacentSeats.count { it.isOccupied } >= 4) { //                            replaceSeat(x, y, 'L')
                        shuffledSeatsCount++ //                        findSeat(seat.position, seats).clear()
                        val rowCharArray = seatLayout[seat.position.second].toCharArray()
                        rowCharArray[seat.position.first] = 'L'
                        seatLayout[seat.position.second] = String(rowCharArray)
                    }
                }
            }
        }

        println("shuffleSeats after! ${old != seatLayout}")
        return shuffledSeatsCount
    }

    private fun findSeat(position: Pair<Int, Int>, s: List<List<Seat>>): Seat = s[position.first][position.second]

    private fun findAdjacentSeats(currentPosition: Seat, s: List<List<Seat>>): List<Seat> { // seat above
        val adjacentPositions: List<Pair<Int, Int>> =
            listOf(currentPosition.positionTop(),
                   currentPosition.positionRightTop(),
                   currentPosition.positionRight(),
                   currentPosition.positionRightBottom(),
                   currentPosition.positionBottom(),
                   currentPosition.positionLeftBottom(),
                   currentPosition.positionLeft(),
                   currentPosition.positionLeftTop()).filter {
                it.first >= 0 && it.first < seatLayout.first().length && it.second >= 0 && it.second < seatLayout.size
            }
        return adjacentPositions.map { findSeat(it, s) }.filter { !it.isFloor }
    }
}