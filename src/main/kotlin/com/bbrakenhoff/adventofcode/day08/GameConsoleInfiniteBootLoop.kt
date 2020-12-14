package com.bbrakenhoff.adventofcode.day08

class GameConsoleInfiniteBootLoop(rawInstructions: List<String>) : GameConsole(rawInstructions) {

    override fun boot() {
        while (!isInInfiniteLoop()) {
            val nextInstruction: GameBootInstruction = nextInstruction()
            updateAccumulator(nextInstruction)
            nextInstruction.updateExecutionTimes()
            updateNextInstructionIndex()
        }
    }

    override fun createInstructions(): List<GameBootInstruction> = rawInstructions.map { GameBootInstruction.parseRaw(it) }
}
