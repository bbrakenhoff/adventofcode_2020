package com.bbrakenhoff.adventofcode.day08

sealed class GameBootInstruction(open val amount: Int, open val increase: Boolean, var executedTimes: Int = 0) {

    data class Accumulator(override val amount: Int, override val increase: Boolean) : GameBootInstruction(amount, increase) {

        override fun calculateNewAccumulator(accumulator: Int): Int {
            var newAccumulator: Int = accumulator

            if (notYetExecuted()) {
                newAccumulator = if (increase) {
                    accumulator + amount
                } else {
                    accumulator - amount
                }
            }

            return newAccumulator
        }

        private fun notYetExecuted(): Boolean = executedTimes == 0

        override fun calculateNextInstructionIndex(nextInstructionIndex: Int): Int = nextInstructionIndex + 1
    }

    data class Jump(override val amount: Int, override val increase: Boolean) : GameBootInstruction(amount, increase) {
        override fun calculateNewAccumulator(accumulator: Int): Int = accumulator

        override fun calculateNextInstructionIndex(nextInstructionIndex: Int): Int {
            return if (increase) {
                nextInstructionIndex + amount
            } else {
                nextInstructionIndex - amount
            }
        }
    }

    data class NoOperation(override val amount: Int, override val increase: Boolean) : GameBootInstruction(amount, increase) {
        override fun calculateNewAccumulator(accumulator: Int): Int = accumulator

        override fun calculateNextInstructionIndex(nextInstructionIndex: Int): Int = nextInstructionIndex + 1
    }

    abstract fun calculateNewAccumulator(accumulator: Int): Int

    abstract fun calculateNextInstructionIndex(nextInstructionIndex: Int): Int

    fun updateExecutionTimes() {
        executedTimes++
    }

    companion object {
        fun parseRaw(rawInstruction: String): GameBootInstruction {
            val instructionRegexResult: MatchResult? = INSTRUCTION_REGEX.matchEntire(rawInstruction)
            val type: String = instructionRegexResult?.groupValues?.get(1).orEmpty()
            val increase: Boolean = instructionRegexResult?.groupValues?.get(2) == "+"
            val amount: Int = instructionRegexResult?.groupValues?.get(3)?.toInt() ?: 0

            return when (type) {
                "jmp" -> Jump(amount, increase)
                "acc" -> Accumulator(amount, increase)
                "nop" -> NoOperation(amount, increase)
                else -> throw IllegalArgumentException("Illegal operation $type")
            }
        }

        private val INSTRUCTION_REGEX: Regex = Regex("([a-z]{3})\\s([+\\-])(\\d+)")
    }
}
