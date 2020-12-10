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

    fun findSumFirstError(): Long {
        val firstError = findFirstError()

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