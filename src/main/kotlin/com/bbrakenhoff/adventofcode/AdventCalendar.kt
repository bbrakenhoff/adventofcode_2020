package com.bbrakenhoff.adventofcode

object AdventCalendar {

    fun run() {
        for (day in StartDay..TotalDays) {
            runDay(day)
        }
    }

    private fun runDay(day: Int) {
        try {
            val dayClassName = buildClassNameForDay(day)
            val dayClass = Class.forName(dayClassName)
            val dayConstructor = dayClass.getConstructor()
            val runMethod = dayClass.getMethod(RunMethod)
            val dayInstance: Day = dayConstructor.newInstance() as Day
            runMethod.invoke(dayInstance)
        } catch (e: ClassNotFoundException) {
            println("========================= Day $day not present =========================")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun buildClassNameForDay(day: Int): String {
        val classNameBuilder: StringBuilder = StringBuilder(Package)

        appendDayNumber(day, classNameBuilder)
        classNameBuilder.append('.')
        classNameBuilder.append(PrefixDayClass)
        appendDayNumber(day, classNameBuilder)

        return classNameBuilder.toString()
    }

    private fun appendDayNumber(day: Int, classNameBuilder: StringBuilder) {
        val appendZero = day < 10

        if (appendZero) {
            classNameBuilder.append('0')
        }

        classNameBuilder.append(day)
    }

    private const val Package = "com.bbrakenhoff.adventofcode.day"
    private const val PrefixDayClass = "Day"
    private const val RunMethod = "run"
    private const val StartDay: Int = 1
    private const val TotalDays: Int = 31
}
