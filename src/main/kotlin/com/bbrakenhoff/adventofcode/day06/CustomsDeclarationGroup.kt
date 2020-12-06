package com.bbrakenhoff.adventofcode.day06

class CustomsDeclarationGroup(private val questionsYesAnswered: List<String>) {

    private val allQuestionsYesAnswered = questionsYesAnswered.joinToString("")

    fun countAllYesAnswers(): Int {
        val questionSet: MutableSet<Char> = mutableSetOf()
        allQuestionsYesAnswered.map { questionSet.add(it) }
        return questionSet.size
    }

    fun countUnanimouslyYesAnswers(): Int {
        val groupedQuestions: Map<Char, List<Char>> = allQuestionsYesAnswered.groupBy { it }
        val yesCountPerQuestion: Map<Char, Int> = groupedQuestions.mapValues { it.value.size }
        val unanimousYesAnswers: Map<Char, Int> = yesCountPerQuestion.filter { it.value == questionsYesAnswered.size }
        return unanimousYesAnswers.size
    }
}
