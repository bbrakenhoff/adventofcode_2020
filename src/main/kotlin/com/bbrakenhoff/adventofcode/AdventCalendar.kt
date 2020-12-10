package com.bbrakenhoff.adventofcode

import java.lang.reflect.Constructor

object AdventCalendar {

    fun print(focused: Boolean = true) {
        println(CALENDAR_HEADER)
        printDays(focused)
        println(CALENDAR_FOOTER)
    }

    private fun printDays(focused: Boolean) {
        for (day: Int in START_DAY..TOTAL_DAYS) {
            val dayNumberText: String = buildDayNumberText(day)
            val dayInstance: Day? = buildDayInstance(dayNumberText)
            printDay(dayInstance, dayNumberText, focused)
        }
    }

    private fun buildDayNumberText(day: Int): String = day.toString().padStart(2, '0')

    private fun buildDayInstance(dayNumberText: String): Day? {
        var dayInstance: Day? = null
        try {
            val dayClassName: String = buildClassNameForDay(dayNumberText)
            val dayClass: Class<*> = Class.forName(dayClassName)
            val dayConstructor: Constructor<out Any> = dayClass.getConstructor()
            dayInstance = dayConstructor.newInstance() as Day
        } catch (e: ClassNotFoundException) { // Do nothing, just return null
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return dayInstance
    }

    private fun buildClassNameForDay(dayNumberText: String): String = String.format(CLASS_NAME, dayNumberText, dayNumberText)

    private fun printDay(dayInstance: Day?, dayNumberText: String, focused: Boolean) {
        val shouldPrint: Boolean = !focused || (focused && dayInstance != null && dayInstance.enabledFocusedPrint)
        if (shouldPrint) {
            printDayHeader(dayNumberText)
            printDayResult(dayInstance)
            printDayFooter()
        }
    }

    private fun printDayHeader(dayNumberText: String) {
        println(String.format(DAY_HEADER, dayNumberText))
        println()
    }

    private fun printDayResult(dayInstance: Day?) {
        val answerPartOne: String = answerText(dayInstance?.partOne())
        println(String.format(DAY_PART_ONE, answerPartOne))

        val answerPartTwo: String = answerText(dayInstance?.partTwo())
        println(String.format(DAY_PART_TWO, answerPartTwo))
    }

    private fun answerText(solution: String?): String = solution?.ifBlank { NOT_SOLVED_YET }
        ?: NOT_SOLVED_YET

    private fun printDayFooter() {
        println()
        println(DAY_FOOTER)
    }

    private const val START_DAY: Int = 1
    private const val TOTAL_DAYS: Int = 25
    private const val CLASS_NAME: String = "com.bbrakenhoff.adventofcode.day%s.Day%s"
    private const val CALENDAR_HEADER: String = "########################## Advent of Code 2020 ##########################"
    private const val CALENDAR_FOOTER: String = "#########################################################################"
    private const val DAY_HEADER: String = "================================= Day %s ================================"
    private const val DAY_FOOTER: String = "========================================================================="
    private const val NOT_SOLVED_YET: String = "NOT SOLVED YET"
    private const val DAY_PART_ONE: String = "Part One: %s"
    private const val DAY_PART_TWO: String = "Part Two: %s"
}
