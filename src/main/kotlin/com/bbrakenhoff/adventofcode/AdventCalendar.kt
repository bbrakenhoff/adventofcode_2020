package com.bbrakenhoff.adventofcode

object AdventCalendar {

    fun run() {
        AdventCalendarBuilder.appendln(CalendarHeader)

        for (day in StartDay..TotalDays) {
            val dayInstance = buildDayInstance(day)
            runDay(dayInstance, day)
        }

        AdventCalendarBuilder.appendln()
        AdventCalendarBuilder.appendln(CalendarFooter)

        print(AdventCalendarBuilder.toString())
    }

    private fun buildDayInstance(day: Int): Day? {
        var dayInstance: Day? = null
        try {
            val dayClassName = buildClassNameForDay(day)
            val dayClass = Class.forName(dayClassName)
            val dayConstructor = dayClass.getConstructor()
            dayInstance = dayConstructor.newInstance() as Day
        } catch (e: ClassNotFoundException) {
            // Do nothing
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return dayInstance
    }

    private fun buildClassNameForDay(day: Int): String {
        val dayNumberText = buildDayNumberText(day)
        val classNameBuilder: StringBuilder = StringBuilder(Package)

        classNameBuilder.append(dayNumberText)
        classNameBuilder.append('.')
        classNameBuilder.append(PrefixDayClass)
        classNameBuilder.append(dayNumberText)

        return classNameBuilder.toString()
    }

    private fun buildDayNumberText(day: Int): String {
       return day.toString().padStart(2, '0')
    }

    private fun runDay(dayInstance: Day?, day: Int) {
        val dayNumberText = buildDayNumberText(day)
        AdventCalendarBuilder.appendln(String.format(DayHeader, dayNumberText))
        AdventCalendarBuilder.appendln()

        val dayResult = dayInstance?.run() ?: "NOT SOLVED YET"
        AdventCalendarBuilder.appendln(dayResult)

        AdventCalendarBuilder.appendln()
        AdventCalendarBuilder.appendln(DayFooter)
    }

    private val AdventCalendarBuilder = StringBuilder()
    private const val StartDay: Int = 1
    private const val TotalDays: Int = 25
    private const val Package = "com.bbrakenhoff.adventofcode.day"
    private const val PrefixDayClass = "Day"
    private const val CalendarHeader = "######################### Advent of Code 2020 #########################"
    private const val CalendarFooter = "#######################################################################"
    private const val DayHeader = "================================ Day %s ================================"
    private const val DayFooter = "======================================================================="
}
