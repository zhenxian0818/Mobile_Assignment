package com.example.mobileassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class QuizRulesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_rules)


        val home =  findViewById<Button>(R.id.backtoQuizButton)



        home.setOnClickListener {
            val intent = Intent(this, QuizTitleActivity::class.java)
            startActivity(intent)
        }
    }
}