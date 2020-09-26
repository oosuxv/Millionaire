package ru.example.millionaire

class QuestionDB : QuestionSource {
    private val questions = mutableListOf<Question>()

    init {
        questions.add(parseQuestion(1, "Завершите философскую русскую пословицу: \"Век живи, век учись - ...\",Академиком станешь,Богатеньким будешь,В люди выйдешь,Дураком помрешь,D"))
        questions.add(parseQuestion(1, "Какое небесное тело используется для определения известных актеров, спортсменов и музыкантов?,Астероид,Комета,Звезда,Планета,C"))
        questions.add(parseQuestion(1, "С чем, согласно поговорке, не следует путать божий дар?,С окрошкой,С антрекотом,С пельменями,С яичницей,D"))
        questions.add(parseQuestion(2, "Какая из карточных мастей изображается в виде красного сердечка?,Пики,Трефы,Бубны,Червы,D   "))
        questions.add(parseQuestion(2, "Какое брюхо, согласно спорной русской пословице, глухо к ученью?,Толстое,Тощее,Сытое,Пустое,C"))
        questions.add(parseQuestion(2, "Кто отказал в помощи удрученной тоской Стрекозе?,Пчела,Жук,Муравей,Стрекозел,C"))
        questions.add(parseQuestion(3, "Известный датчанин Ганс Христиан Андерсен прославился тем, что умел из чистой бумаги делать:,Кораблики,Сказки,Самолетики,Порох,B"))
        questions.add(parseQuestion(3, "Какой из этих напитков выпускается и в безалкогольном варианте?,Коньяк,Водка,Пиво,Портвейн,C"))
        questions.add(parseQuestion(3, "Как звали кота-обжору, игнорировавшего сентенции повара?,Барсик,Матроскин,Мурзик,Васька,D"))
        questions.add(parseQuestion(4, "Канделябр - это:,Большой подсвечник,Старинный шкаф,Друг Бармалея,Жанр Е. Петросяна,A"))
        questions.add(parseQuestion(4, "В русских сказках медведя именовали:,Михаил Иваныч,Михаил Потапыч,Михаил Сергеевич,Борис Николаевич,B"))
        questions.add(parseQuestion(4, "Что означает буква \"О\" в аббревиатуре ОРТ?,Олигархическое,Объективное,Общественное,Однообразное,C"))
        questions.add(parseQuestion(5, "В какую страну мечтал попасть Остап Бендер?,США,Австралия,Бразилия,Аргентина,C"))
        questions.add(parseQuestion(5, "Какая из этих моделей автомобилей ВАЗ - первая переднеприводная?,2104,2107,2108,2111,C"))
        questions.add(parseQuestion(5, "Птица с каким из этих названий существует?,Чих,Сип,Храп,Хрип,B"))
    }

    override fun getQuestion(level: Int): Question {
        return questions.filter { it.level == level }.random()
    }

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