package com.bbrakenhoff.adventofcode.day09

class XmasDecryptor(private val numbers: List<Long>, private val preamble: Int) {

    fun findFirstError(): Long {
        var i = preamble
        var errorFound = false
        var invalidNumber = -1L

        while (!errorFound) {
            val previousNumbers = numbers.subList(i - preamble, i)
            val other = previousNumbers.find { previousNumbers.contains(numbers[i] - it) }

            if (other == null) {
                errorFound = true
                invalidNumber = numbers[i]
            }

            i++
        }

        return invalidNumber
    }
}