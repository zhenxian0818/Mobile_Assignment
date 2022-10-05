package com.example.mobileassignment.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.mobileassignment.AchievementsActivity
import com.example.mobileassignment.QuizTitleActivity
import com.example.mobileassignment.R
import java.util.*


class DailyTaskFragment : Fragment() {

    private lateinit var quizBtn: Button
    private lateinit var doneBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_daily_task, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val c = Calendar.getInstance()
        val day = c.get(Calendar.DAY_OF_MONTH)
        super.onCreate(savedInstanceState)

        val settings = this.requireActivity().getSharedPreferences("PREFS", 0)
        val lastDay = settings.getInt("day", 0)

        if (lastDay != day) {
            quizBtn = view.findViewById(R.id.quizButton)
            quizBtn.visibility = View.VISIBLE
            quizBtn.isClickable = true
            quizBtn.setOnClickListener() {
                val intent = Intent(this.requireActivity(), QuizTitleActivity::class.java)
                startActivity(intent)
            }
            doneBtn = view.findViewById(R.id.doneActivityBtn)
            doneBtn.setOnClickListener(){
                val editor = settings.edit()
                editor.putInt("day", day)
                editor.commit()
                val intent = Intent(this.requireActivity(), AchievementsActivity::class.java)
                startActivity(intent)
            }
        }
    }
}