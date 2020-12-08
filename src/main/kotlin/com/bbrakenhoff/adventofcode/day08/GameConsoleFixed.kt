package com.bbrakenhoff.adventofcode.day08

class GameConsoleFixed(rawInstructions: List<String>) : GameConsole(rawInstructions) {

    private var nextJumpToReplaceIndex: Int = -1

    override fun boot() {
        while (!isInInfiniteLoop() && bootNotYetComplete()) {
            val instruction: Instruction = nextInstruction()
            updateAccumulator(instruction)
            updateNextInstructionIndex()
            instruction.updateExecutionTimes()

            if (isInInfiniteLoop()) {
                restartBoot()
            }
        }
    }

    private fun bootNotYetComplete() = nextInstructionIndex < instructions.size

    override fun createInstructions(): List<Instruction> {
        return if (restartedBoot) {
            replaceJump()
        } else {
            rawInstructions.map { Instruction.parseRaw(it) }
        }
    }

    private fun replaceJump(): List<Instruction> {
        calculateNextJumpToReplaceIndex()
        return rawInstructions.mapIndexed { i: Int, rawInstruction: String ->
            if (i == nextJumpToReplaceIndex) {
                Instruction.NoOperation(1, true)
            } else {
                Instruction.parseRaw(rawInstruction)
            }
        }
    }

    private fun calculateNextJumpToReplaceIndex() {
        nextJumpToReplaceIndex++ // make sure the replace is at the jump

        var i = nextJumpToReplaceIndex

        while (instructions[i] !is Instruction.Jump) {
            i++
        }

        nextJumpToReplaceIndex = i
    }
}
