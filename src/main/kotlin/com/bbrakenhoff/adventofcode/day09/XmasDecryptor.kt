package com.bbrakenhoff.adventofcode.day09

class XmasDecryptor(private val numbers: List<Long>, private val preamble: Int) {

    fun findFirstInvalidNumber(): Long {
        var i: Int = preamble
        var invalidNumberFound: Boolean = false
        var invalidNumber: Long = -1L

        while (!invalidNumberFound) {
            val previousNumbers: List<Long> = numbers.subList(i - preamble, i)
            val foundNumberInPreviousNumbers = findNumberInPreviousNumbers(previousNumbers, i)

            if (!foundNumberInPreviousNumbers) {
                invalidNumberFound = true
                invalidNumber = numbers[i]
            }

            i++
        }

        return invalidNumber
    }

    private fun findNumberInPreviousNumbers(previousNumbers: List<Long>, i: Int): Boolean =
        previousNumbers.any { previousNumbers.contains(numbers[i] - it) }

    fun findEncryptionWeakness(): Long {
        val firstError = findFirstInvalidNumber()

        var firstIndex = 0
        var previousNumbers = numbers.subList(firstIndex, numbers.indexOf(firstError))

        var sumFound = false
        var i = 0
        val sumList = mutableListOf<Long>()

        while (!sumFound) {
            val number = previousNumbers[i]

            sumList.add(number)
            val sum = sumList.sum()
            if (sum == firstError) {
                sumFound = true
            } else {

                i++

                if (i == previousNumbers.size) {
                    i = 0
                    firstIndex++
                    previousNumbers = numbers.subList(firstIndex, numbers.indexOf(firstError))
                    sumList.clear()
                }
            }
        }

        return sumList.min()!!.plus(sumList.max()!!)
    }
}
