package com.bbrakenhoff.adventofcode

object AdventCalendar {

    fun print(focused: Boolean = true) {
        println(CalendarHeader)
        printDays(focused)
        println(CalendarFooter)
    }

    private fun printDays(focused: Boolean) {
        for (day in StartDay..TotalDays) {
            val dayNumberText = buildDayNumberText(day)
            val dayInstance = buildDayInstance(dayNumberText)
            printDay(dayInstance, dayNumberText, focused)
        }
    }

    private fun buildDayNumberText(day: Int): String = day.toString().padStart(2, '0')

    private fun buildDayInstance(dayNumberText: String): Day? {
        var dayInstance: Day? = null
        try {
            val dayClassName = buildClassNameForDay(dayNumberText)
            val dayClass = Class.forName(dayClassName)
            val dayConstructor = dayClass.getConstructor()
            dayInstance = dayConstructor.newInstance() as Day
        } catch (e: ClassNotFoundException) {
            // Do nothing, just return null
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return dayInstance
    }

    private fun buildClassNameForDay(dayNumberText: String): String = String.format(ClassName, dayNumberText, dayNumberText)

    private fun printDay(dayInstance: Day?, dayNumberText: String, focused: Boolean) {
        val shouldPrint = !focused || (focused && dayInstance != null && dayInstance.enabledFocusedPrint)
        if (shouldPrint) {
            printDayHeader(dayNumberText)
            printDayResult(dayInstance)
            printDayFooter()
        }
    }

    private fun printDayHeader(dayNumberText: String) {
        println(String.format(DayHeader, dayNumberText))
        println()
    }

    private fun printDayResult(dayInstance: Day?) {
        val dayResult = dayInstance?.partA() ?: "NOT SOLVED YET"
        println(dayResult)
    }

    private fun printDayFooter() {
        println()
        println(DayFooter)
    }

    private const val StartDay: Int = 1
    private const val TotalDays: Int = 25
    private const val ClassName = "com.bbrakenhoff.adventofcode.day%s.Day%s"
    private const val CalendarHeader = "########################## Advent of Code 2020 ##########################"
    private const val CalendarFooter = "#########################################################################"
    private const val DayHeader = "================================= Day %s ================================"
    private const val DayFooter = "========================================================================="
}
