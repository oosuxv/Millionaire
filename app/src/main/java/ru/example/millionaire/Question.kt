package ru.example.millionaire

data class Question(
    val text: String,
    val choices: List<String>,
    val answer: Int,
    val level: Int
) {
    companion object {
        fun parseQuestion(level: Int, data: String) : Question {
            var splitted = data.split(",")
            val answer = when (splitted.last()) {
                "A" -> 0
                "B" -> 1
                "C" -> 2
                "D" -> 3
                else -> -1
            }
            splitted = splitted.dropLast(1)
            val choices = mutableListOf<String>()
            for (i in 1..4) {
                choices.add(0, splitted.last())
                splitted = splitted.dropLast(1)
            }
            val text = splitted.joinToString()
            return Question(text, choices, answer, level)
        }
    }
}
