package com.example.mobileassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class QuizGameActivity : AppCompatActivity() {
    //Setting Global Variables
    private val questions = QuizQuestions.quizquestions
    private var correctAnswer: String? = null
    private var questionNumber: Int = 1
    private var score: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_game)

        Log.i("Question Size", "${questions.size}")

        //Displaying Questions
        showQuestion()

    }

    fun showQuestion()
    {
        //Setting Variables
        val questionText = findViewById<TextView>(R.id.questionText)
        val option1 = findViewById<TextView>(R.id.option1Button)
        val option2 = findViewById<TextView>(R.id.option2Button)
        val option3 = findViewById<TextView>(R.id.option3Button)
        val option4 = findViewById<TextView>(R.id.option4Button)
        val questionNum = findViewById<TextView>(R.id.questionNumber)

        //Changing the Question Number
        questionNum.text = questionNumber.toString()

        //Shuffling the Questions from QuizQuestions
        questions.shuffle()

        //Creating a Variable to store the Questions
        val question = questions[0]
        correctAnswer = question[4]

        Log.i("Question Answer", "$correctAnswer")

        //Setting Question from List
        questionText.text = question[0]

        //Remove the Question from the List; So it doesn't get randomized into the answers
        question.removeAt(0)

        //Setting Answer from List
        question.shuffle()

        //Setting Answers from List
        option1.text = question[0]
        option2.text = question[1]
        option3.text = question[2]
        option4.text = question[3]

        //Removing the Question once it has appeared
        questions.removeAt(0)

        //Getting User Input
        option1.setOnClickListener(){
            val userAnswer = option1.text.toString()
            checkAnswerandAddScore(userAnswer)
        }

        option2.setOnClickListener(){
            val userAnswer = option2.text.toString()
            checkAnswerandAddScore(userAnswer)
        }

        option3.setOnClickListener(){
            val userAnswer = option3.text.toString()
            checkAnswerandAddScore(userAnswer)
        }

        option4.setOnClickListener(){
            val userAnswer = option4.text.toString()
            checkAnswerandAddScore(userAnswer)
        }

    }

    //Check if the Answer is Correct or Wrong; Add Points to User's Score
    private fun checkAnswerandAddScore(userAnswer: String)
    {
        //If User Finishes Question 4, Sends them to Result Activity
        if (questionNumber == 4)
        {
            if (userAnswer == correctAnswer)
            {
                Log.i("Answer", "Correct")
                score++
                val intent = Intent(this, QuizResultActivity::class.java)
                intent.putExtra("Score", score)
                startActivity(intent)
            }

            else
            {
                Log.i("Answer", "Incorrect")
                showQuestion()
                val intent = Intent(this, QuizResultActivity::class.java)
                intent.putExtra("Score", score)
                startActivity(intent)
            }
        }

        //If User has not finished Question 4, return back to showQuestion()
        else
        {
            if (userAnswer == correctAnswer)
            {
                Log.i("Answer", "Correct")
                score++
                questionNumber++
                showQuestion()
            }

            else
            {
                Log.i("Answer", "Incorrect")
                questionNumber++
                showQuestion()
            }

        }
    }
}