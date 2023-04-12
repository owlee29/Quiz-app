package com.example.testing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonStart : Button = findViewById(R.id.buttonStart)
        val editTextName : EditText = findViewById(R.id.editText_Name)

        buttonStart.setOnClickListener {
            if(editTextName.text.isEmpty()) {
                Toast.makeText(this,
                    "Please enter your name", Toast.LENGTH_LONG).show()
            } else {
                val intent = Intent(this, QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.PLAYER_NAME, editTextName.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}