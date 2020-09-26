package ru.example.millionaire

data class Question(
    val text: String,
    val choices: List<String>,
    val answer: Int,
    val level: Int
)

