package com.bbrakenhoff.adventofcode.day06

class CustomsDeclarationGroup(private val groupAnswers: List<String>) {

    fun countYesAnswers(): Int {
        val answerSet: MutableSet<Char> = mutableSetOf()

        groupAnswers.joinToString("").map {
            answerSet.add(it)
        }

        return answerSet.size
    }
}
