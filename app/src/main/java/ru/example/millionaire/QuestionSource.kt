package ru.example.millionaire

interface QuestionSource {
    fun getQuestion(level: Int) : Question
}