package com.bbrakenhoff.adventofcode.day05

class BoardingPass(private val text: String) {
    fun findSeatId(): Int {
        return text.replace('F', '0').replace('B', '1').replace('L', '0').replace('R', '1').toInt(2)
    }

    companion object {
        private const val TOTAL_ROWS = 128
        private const val TOTAL_COLUMNS = 8
    }
}
