package com.bbrakenhoff.adventofcode.day08

sealed class Instruction(open val amount: Int, open val increase: Boolean, var executedTimes: Int = 0) {

    data class Accumalator(override val amount: Int, override val increase: Boolean) : Instruction(amount, increase)
    data class Jump(override val amount: Int, override val increase: Boolean) : Instruction(amount, increase)
    data class NoOperation(override val amount: Int, override val increase: Boolean) : Instruction(amount, increase)

    companion object {
        fun parseRaw(rawInstruction: String): Instruction {
            val instructionRegexResult: MatchResult? = INSTRUCTION_REGEX.matchEntire(rawInstruction)
            val type: String = instructionRegexResult?.groupValues?.get(1).orEmpty()
            val increase: Boolean = instructionRegexResult?.groupValues?.get(2) == "+"
            val amount: Int = instructionRegexResult?.groupValues?.get(3)?.toInt() ?: 0

            return when (type) {
                "jmp" -> Jump(amount, increase)
                "acc" -> Accumalator(amount, increase)
                "nop" -> NoOperation(amount, increase)
                else -> throw IllegalArgumentException("Illegal operation $type")
            }
        }

        private val INSTRUCTION_REGEX: Regex = Regex("([a-z]{3})\\s(\\+|-)(\\d+)")
    }
}