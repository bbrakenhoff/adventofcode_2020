package com.bbrakenhoff.adventofcode

object AdventCalendar {

    fun run() {
        print(build())
    }

    private fun build(): String {
        val adventCalendarBuilder = StringBuilder()
        adventCalendarBuilder.appendln(CalendarHeader)

        for (day in StartDay..TotalDays) {
            val dayNumberText = buildDayNumberText(day)
            val dayInstance = buildDayInstance(dayNumberText)
            appendDay(dayInstance, dayNumberText, adventCalendarBuilder)
        }

        adventCalendarBuilder.appendln(CalendarFooter)
        return adventCalendarBuilder.toString()
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

    private fun buildClassNameForDay(dayNumberText: String): String {
        val classNameBuilder: StringBuilder = StringBuilder(Package)

        classNameBuilder.append(dayNumberText)
        classNameBuilder.append('.')
        classNameBuilder.append(PrefixDayClass)
        classNameBuilder.append(dayNumberText)

        return classNameBuilder.toString()
    }

    private fun appendDay(dayInstance: Day?, dayNumberText: String, adventCalendarBuilder: StringBuilder) {
        appendDayHeader(dayNumberText, adventCalendarBuilder)
        appendDayResult(dayInstance, adventCalendarBuilder)
        appendDayFooter(adventCalendarBuilder)
    }

    private fun appendDayHeader(dayNumberText: String, adventCalendarBuilder: StringBuilder) {
        adventCalendarBuilder.appendln(String.format(DayHeader, dayNumberText))
        adventCalendarBuilder.appendln()
    }

    private fun appendDayResult(dayInstance: Day?, adventCalendarBuilder: StringBuilder) {
        val dayResult = dayInstance?.run() ?: "NOT SOLVED YET"
        adventCalendarBuilder.appendln(dayResult)
    }

    private fun appendDayFooter(adventCalendarBuilder: StringBuilder) {
        adventCalendarBuilder.appendln()
        adventCalendarBuilder.appendln(DayFooter)
    }

    private const val StartDay: Int = 1
    private const val TotalDays: Int = 25
    private const val Package = "com.bbrakenhoff.adventofcode.day"
    private const val PrefixDayClass = "Day"
    private const val CalendarHeader = "######################### Advent of Code 2020 #########################"
    private const val CalendarFooter = "#######################################################################"
    private const val DayHeader = "================================ Day %s ================================"
    private const val DayFooter = "========================================================================"
}
