package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import com.example.mobileassignment.R

class LearningActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private lateinit var learningSpinner : Spinner
    private lateinit var learningAns : TextView

    private lateinit var learningAnsArray : Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learning)

        learningSpinner = findViewById(R.id.learningQuestions)
        learningAns = findViewById(R.id.learningAnswer)
        learningAnsArray = resources.getStringArray(R.array.learningAnswerSpinner)

        ArrayAdapter.createFromResource(
            this,
            R.array.learningQuestionsSpinner,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            learningSpinner.adapter = adapter
        }
        learningSpinner.onItemSelectedListener = this
    }

    override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
        when(position){
            0 -> learningAns.text =learningAnsArray[position]

            1 -> learningAns.text =learningAnsArray[position]

            2 -> learningAns.text =learningAnsArray[position]

            3 -> learningAns.text =learningAnsArray[position]

            4 -> learningAns.text =learningAnsArray[position]

            5 -> learningAns.text =learningAnsArray[position]

            6 -> learningAns.text =learningAnsArray[position]

            7 -> learningAns.text =learningAnsArray[position]

            8 -> learningAns.text =learningAnsArray[position]
        }

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        learningAns.text = ""
    }
}