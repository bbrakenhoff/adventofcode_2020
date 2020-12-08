package com.bbrakenhoff.adventofcode.day08

class GameConsole(rawInstructions: List<String>) {

    private var _accumulator: Int = 0
    val accumulator: Int
        get() = _accumulator

    private val instructions: List<Instruction> = rawInstructions.map { Instruction.parseRaw(it) }

    private var nextInstructionIndex: Int = 0

    fun boot() {
        while (!isAnyInstructionExecutedTwice()) {
            val currentInstruction: Instruction = instructions[nextInstructionIndex]
            updateExecutedTimes(currentInstruction)
            executeInstruction(currentInstruction)
        }
    }

    private fun isAnyInstructionExecutedTwice(): Boolean = instructions.any { it.executedTimes > 1 }

    private fun updateExecutedTimes(instruction: Instruction) {
        instruction.executedTimes++
    }

    private fun executeInstruction(instruction: Instruction) {
        if (!isAnyInstructionExecutedTwice()) {
            if (instruction is Instruction.Accumalator) {
                calculateAccumalator(instruction)
            }

            calculateNextInstructionIndex(instruction)
        }
    }

    private fun calculateAccumalator(instruction: Instruction.Accumalator) {
        if (instruction.increase) {
            _accumulator += instruction.amount
        } else {
            _accumulator -= instruction.amount
        }
    }

    private fun calculateNextInstructionIndex(instruction: Instruction) {
        if (instruction is Instruction.Jump) {
            jump(instruction)
        } else {
            nextInstructionIndex++
        }
    }

    private fun jump(instruction: Instruction.Jump) {
        if (instruction.increase) {
            nextInstructionIndex += instruction.amount
        } else {
            nextInstructionIndex -= instruction.amount
        }
    }
}