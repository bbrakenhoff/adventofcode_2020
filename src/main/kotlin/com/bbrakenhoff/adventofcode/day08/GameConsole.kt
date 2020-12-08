package com.bbrakenhoff.adventofcode.day08

abstract class GameConsole(protected val rawInstructions: List<String>) {

    private var _accumulator: Int = 0
    val accumulator: Int
        get() = _accumulator

    private var _nextInstructionIndex: Int = 0
    protected val nextInstructionIndex: Int
        get() = _nextInstructionIndex

    private var _instructions: List<Instruction> = createInstructions()
    protected val instructions: List<Instruction>
        get() = _instructions

    private var _restartedBoot: Boolean = false
    protected val restartedBoot: Boolean
        get() = _restartedBoot

    abstract fun boot()

    protected open fun createInstructions(): List<Instruction> = rawInstructions.map { Instruction.parseRaw(it) }

    protected fun isInInfiniteLoop() = instructions.any { it.executedTimes > 1 }

    protected fun updateAccumulator(instruction: Instruction) {
        _accumulator = instruction.calculateNewAccumulator(_accumulator)
    }

    protected fun nextInstruction(): Instruction = instructions[_nextInstructionIndex]

    protected fun updateNextInstructionIndex() {
        _nextInstructionIndex = instructions[_nextInstructionIndex].calculateNextInstructionIndex(_nextInstructionIndex)
    }

    protected fun restartBoot() {
        _restartedBoot = true
        _accumulator = 0
        _nextInstructionIndex = 0
        _instructions = createInstructions()
        boot()
    }
}
