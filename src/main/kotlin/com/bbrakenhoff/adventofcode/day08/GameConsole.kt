package com.bbrakenhoff.adventofcode.day08

class GameConsole(private val rawInstructions: List<String>) {

    private var _accumulator: Int = 0
    val accumulator: Int
        get() = _accumulator

    private var instructions: List<Instruction> = rawInstructions.map { Instruction.parseRaw(it) }

    private var nextInstructionIndex: Int = 0
    private var indexJumpToReplace: Int = 0

    fun boot() {
        while (!isAnyInstructionExecutedTwice()) {
            val currentInstruction: Instruction = instructions[nextInstructionIndex]
            updateExecutedTimes(currentInstruction)

            if (!isAnyInstructionExecutedTwice()) {
                executeInstruction(currentInstruction)
            }
        }
    }

    private fun isAnyInstructionExecutedTwice(): Boolean = instructions.any { it.executedTimes > 1 }

    private fun updateExecutedTimes(instruction: Instruction) {
        instruction.executedTimes++
    }

    private fun executeInstruction(instruction: Instruction) {
        if (instruction is Instruction.Accumalator) {
            calculateAccumalator(instruction)
        }

        calculateNextInstructionIndex(instruction)
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

    fun fixedBoot() {
        while (!isAnyInstructionExecutedTwice() && !isBootComplete()) {
            val currentInstruction: Instruction = instructions[nextInstructionIndex]

            updateExecutedTimes(currentInstruction)

            if (!isAnyInstructionExecutedTwice()) {
                executeInstruction(currentInstruction)
            } else {
                restartFixedBoot()
            }
        }
    }

    private fun isBootComplete(): Boolean = nextInstructionIndex >= instructions.size

    private fun restartFixedBoot() {
        replaceJumpWithNoOperationInstruction()
        reset()
        fixedBoot()
    }

    private fun reset() {
        nextInstructionIndex = 0
        _accumulator = 0
    }

    private fun replaceJumpWithNoOperationInstruction() {
        calculateNextJumpToReplace()

        instructions = rawInstructions.mapIndexed { i: Int, rawInstruction: String ->
            var instruction: Instruction = Instruction.parseRaw(rawInstruction)

            if (i == indexJumpToReplace) {
                instruction = Instruction.NoOperation(1, true)
            }

            instruction
        }
    }

    private fun calculateNextJumpToReplace() {
        var i = 0

        if (indexJumpToReplace > 0) {
            i = indexJumpToReplace + 1
        }

        while (instructions[i] !is Instruction.Jump) {
            i++
        }

        indexJumpToReplace = i
    }
}