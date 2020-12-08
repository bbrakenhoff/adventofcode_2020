package com.bbrakenhoff.adventofcode.day06

class CustomsDeclarationGroup(private val questionsYesAnswered: List<String>) {

    private val allQuestionsYesAnswered = questionsYesAnswered.joinToString("")

    fun countAllYesAnswers(): Int {
        return allQuestionsYesAnswered.map { it }.distinct().size
    }

    fun countUnanimouslyYesAnswers(): Int {
        val groupedQuestions: Map<Char, List<Char>> = allQuestionsYesAnswered.groupBy { it }
        val yesCountPerQuestion: Map<Char, Int> = groupedQuestions.mapValues { it.value.size }
        val unanimousYesAnswers: Map<Char, Int> = yesCountPerQuestion.filter { it.value == questionsYesAnswered.size }
        return unanimousYesAnswers.size
    }
}
