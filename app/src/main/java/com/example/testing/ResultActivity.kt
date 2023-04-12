package com.example.testing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val textViewName: TextView = findViewById(R.id.textView_playerName)
        val textViewScore: TextView = findViewById(R.id.textView_score)
        val buttonFinish: Button = findViewById(R.id.button_Finish)

        textViewName.text = intent.getStringExtra(Constants.PLAYER_NAME)

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)

        textViewScore.text = "Your score is $correctAnswers out of $totalQuestions"

        buttonFinish.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}