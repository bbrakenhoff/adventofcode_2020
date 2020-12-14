package com.bbrakenhoff.adventofcode.day08

class GameConsoleFixed(rawInstructions: List<String>) : GameConsole(rawInstructions) {

    private var nextJumpToReplaceIndex: Int = -1

    override fun boot() {
        while (!isInInfiniteLoop() && bootNotYetComplete()) {
            val instruction: GameBootInstruction = nextInstruction()
            updateAccumulator(instruction)
            updateNextInstructionIndex()
            instruction.updateExecutionTimes()

            if (isInInfiniteLoop()) {
                restartBoot()
            }
        }
    }

    private fun bootNotYetComplete(): Boolean = nextInstructionIndex < instructions.size

    override fun createInstructions(): List<GameBootInstruction> {
        return if (restartedBoot) {
            replaceJump()
        } else {
            rawInstructions.map { GameBootInstruction.parseRaw(it) }
        }
    }

    private fun replaceJump(): List<GameBootInstruction> {
        calculateNextJumpToReplaceIndex()
        return rawInstructions.mapIndexed { i: Int, rawInstruction: String ->
            if (i == nextJumpToReplaceIndex) {
                GameBootInstruction.NoOperation(1, true)
            } else {
                GameBootInstruction.parseRaw(rawInstruction)
            }
        }
    }

    private fun calculateNextJumpToReplaceIndex() {
        nextJumpToReplaceIndex++ // make sure the replace is at the next jump

        var i: Int = nextJumpToReplaceIndex

        while (instructions[i] !is GameBootInstruction.Jump) {
            i++
        }

        nextJumpToReplaceIndex = i
    }
}
