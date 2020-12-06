package com.bbrakenhoff.adventofcode.day06

class CustomsDeclarationGroup(private val groupAnswers: List<String>) {

    fun countAllYesAnswers(): Int {
        val answerSet: MutableSet<Char> = mutableSetOf()

        groupAnswers.joinToString("").map {
            answerSet.add(it)
        }

        return answerSet.size
    }

    fun countUnanimouslyYesAnswers(): Int {
        val groupedAnswers: Map<Char, List<Char>> = groupAnswers.joinToString("").groupBy { it }
        val groupedAnswersCount: Map<Char, Int> = groupedAnswers.mapValues { it.value.size }
        val unanimousAnswers: Map<Char, Int> = groupedAnswersCount.filter { it.value == groupAnswers.size }
        return unanimousAnswers.size
    }
}
