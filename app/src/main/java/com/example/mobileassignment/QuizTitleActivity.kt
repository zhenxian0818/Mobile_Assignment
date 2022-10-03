package com.example.mobileassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class QuizTitleActivity : AppCompatActivity() {

    private lateinit var start : Button
    private lateinit var rules : Button
    private lateinit var home : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_title)

        //Setting Variables
        start =  findViewById(R.id.startButton)
        rules =  findViewById(R.id.rulesButton)
        home =  findViewById(R.id.backButton)


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