package com.bbrakenhoff.adventofcode.day08

abstract class GameConsole(protected val rawInstructions: List<String>) {

    private var _accumulator: Int = 0
    val accumulator: Int
        get() = _accumulator

    private var _nextInstructionIndex: Int = 0
    protected val nextInstructionIndex: Int
        get() = _nextInstructionIndex

    private lateinit var _instructions: List<Instruction>
    protected val instructions: List<Instruction>
        get() = _instructions

    private var _restartedBoot: Boolean = false
    protected val restartedBoot: Boolean
        get() = _restartedBoot

    init {
        updateInstructions()
    }

    /**
     * Use method for initializing instructions, otherwhise might cause leaks through derived classes
     * See [stackoverflow](https://stackoverflow.com/a/50222496/2670098) for explanation
     */
    private fun updateInstructions() {
        _instructions = createInstructions()
    }

    protected abstract fun createInstructions(): List<Instruction>

    abstract fun boot()

    protected fun isInInfiniteLoop(): Boolean = instructions.any { it.executedTimes > 1 }

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
        updateInstructions()
        boot()
    }
}
