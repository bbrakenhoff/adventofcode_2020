package com.bbrakenhoff.adventofcode.day12

sealed class NavigationInstruction(open val units: Int) {

    data class Forward(override val units: Int) : NavigationInstruction(units)

    data class North(override val units: Int) : NavigationInstruction(units)

    data class East(override val units: Int) : NavigationInstruction(units)

    data class South(override val units: Int) : NavigationInstruction(units)

    data class West(override val units: Int) : NavigationInstruction(units)

    data class RotateLeft(override val units: Int) : NavigationInstruction(units)

    data class RotateRight(override val units: Int) : NavigationInstruction(units)

    companion object {
        fun createFromInstructionLine(instructionLine: String): NavigationInstruction {
            val instructionIdentifier: Char = instructionLine[0]
            val units: Int = instructionLine.substring(1).toInt()
            return when (instructionIdentifier) {
                'N' -> North(units)
                'S' -> South(units)
                'E' -> East(units)
                'W' -> West(units)
                'F' -> Forward(units)
                'L' -> RotateLeft(units)
                'R' -> RotateRight(units)
                else -> throw IllegalArgumentException("Unknown instruction identifier: $instructionIdentifier")
            }
        }
    }
}
