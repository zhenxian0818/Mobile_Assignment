package com.example.mobileassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class QuizResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_result)

        val homebutton = findViewById<Button>(R.id.backtoMainButton)
        val restartButtton = findViewById<Button>(R.id.restartButton)
        val totalScore = findViewById<TextView>(R.id.score)
        val result = "/4"

        val score = intent.getIntExtra("Score", 0)

        totalScore.text = score.toString() + result

        homebutton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        restartButtton.setOnClickListener {
            val intent = Intent(this, QuizTitleActivity::class.java)
            startActivity(intent)
        }
    }
    }
