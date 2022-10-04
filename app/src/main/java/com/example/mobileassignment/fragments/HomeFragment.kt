package com.example.mobileassignment.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.mobileassignment.DonationActivity
import com.example.mobileassignment.QuizTitleActivity
import com.example.mobileassignment.R

class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnQuiz : Button = view.findViewById(R.id.btnQuiz)
        val btnHelp : Button = view.findViewById(R.id.btnHelp)

        btnQuiz.setOnClickListener {
            val intent = Intent(this.requireActivity(), QuizTitleActivity::class.java)
            startActivity(intent)
        }

        btnHelp.setOnClickListener {
            val intent = Intent(this.requireActivity(), DonationActivity::class.java)
            startActivity(intent)
        }

    }
}