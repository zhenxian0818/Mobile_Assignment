package com.example.mobileassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class QuizTitleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_title)

        //Setting Variables
        val start =  findViewById<Button>(R.id.startButton)
        val rules =  findViewById<Button>(R.id.rulesButton)
        val home =  findViewById<Button>(R.id.homeButton)


        //Navigating to Different Activities
        start.setOnClickListener {
            val intent = Intent(this, QuizGameActivity::class.java)
            startActivity(intent)
        }

        rules.setOnClickListener {
            val intent = Intent(this, QuizRulesActivity::class.java)
            startActivity(intent)
        }

        home.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}