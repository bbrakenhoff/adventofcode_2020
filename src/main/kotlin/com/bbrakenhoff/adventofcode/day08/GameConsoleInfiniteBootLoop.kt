package com.bbrakenhoff.adventofcode.day08

class GameConsoleInfiniteBootLoop(rawInstructions: List<String>) : GameConsole(rawInstructions) {

    override fun boot() {
        while (!isInInfiniteLoop()) {
            val nextInstruction: Instruction = nextInstruction()
            updateAccumulator(nextInstruction)
            nextInstruction.updateExecutionTimes()
            updateNextInstructionIndex()
        }
    }
}
