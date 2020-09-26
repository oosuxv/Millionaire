package ru.example.millionaire

import androidx.lifecycle.ViewModel

class QuestionViewModel(val questionSource: QuestionSource) : ViewModel() {
    private var lastQuestion: Question? = null

    fun getNextQuestion(): Question {
        lastQuestion =  questionSource.getQuestion(lastQuestion?.level ?: 0 + 1)
        return lastQuestion!!
    }

    fun getFirstQuestion(): Question {
        lastQuestion = null
        return getNextQuestion()
    }

    fun getLastAskedQuestion(): Question {
        return lastQuestion ?: getNextQuestion()
    }
}