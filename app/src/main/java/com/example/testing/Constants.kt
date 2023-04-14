package com.example.testing

object Constants {

    const val PLAYER_NAME : String ="player_name"
    const val TOTAL_QUESTIONS: String ="total_questions"
    const val CORRECT_ANSWERS: String ="correct_answers"

    fun getQuestions() : ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val q1 = Question(
            1,
            "What is the name of this object in the solar system?",
            R.drawable.ic_earth,
            "Ceres", "Earth",
            "Urf", "Aerth",
            2
        )
        questionsList.add(q1)

        val q2 = Question(
            2,
            "What is the name of this object in the solar system?",
            R.drawable.ic_jupiter,
            "Saturn", "Mars",
            "Jupiter", "Sun",
            3
        )

        questionsList.add(q2)

        val q3 = Question(
            3,
            "What is the name of this object in the solar system?",
            R.drawable.ic_mars,
            "Moon", "Pallas",
            "Saturn", "Mars",
            4
        )

        questionsList.add(q3)

        val q4 = Question(
            4,
            "What is the name of this object in the solar system?",
            R.drawable.ic_mercury,
            "Uranus", "Mercury",
            "Moon", "Triton",
            2
        )

        questionsList.add(q4)

        val q5 = Question(
            5,
            "What is the name of this object in the solar system?",
            R.drawable.ic_moon,
            "Phobos", "Star",
            "Moon", "Mercury",
            3
        )

        questionsList.add(q5)

        val q6 = Question(
            6,
            "What is the name of this object in the solar system?",
            R.drawable.ic_neptune,
            "Neptune", "Uranus",
            "Pluto", "None of these",
            1
        )

        questionsList.add(q6)

        val q7 = Question(
            7,
            "What is the name of this object in the solar system?",
            R.drawable.ic_saturn,
            "Vesta", "Mars",
            "Saturn", "Jupiter",
            3
        )

        questionsList.add(q7)

        val q8 = Question(
            8,
            "What is the name of this object in the solar system?",
            R.drawable.ic_sun,
            "Charon", "Saturn",
            "Mars", "Sun",
            4
        )

        questionsList.add(q8)

        val q9 = Question(
            9,
            "What is the name of this object in the solar system?",
            R.drawable.ic_uranus,
            "Neptune", "Uranus",
            "Pluto", "None of these",
            2
        )

        questionsList.add(q9)

        val q10 = Question(
            10,
            "What is the name of this object in the solar system?",
            R.drawable.ic_venus,
            "Venus", "Earth",
            "Neptune", "Palestine",
            1
        )
        questionsList.add(q10)

        questionsList.shuffle()
        return questionsList
    }
}