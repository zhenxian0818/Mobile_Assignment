package com.example.mobileassignment.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.mobileassignment.*

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
        val btnNews : Button = view.findViewById(R.id.btnNews)
        val btnFaq : Button = view.findViewById(R.id.btnFaq)

        btnQuiz.setOnClickListener {
            val intent = Intent(this.requireActivity(), QuizTitleActivity::class.java)
            startActivity(intent)
        }
        btnNews.setOnClickListener{
            val intent = Intent(this.requireActivity(), News::class.java)
            startActivity(intent)
        }

        btnFaq.setOnClickListener{
            val intent = Intent(this.requireActivity(), FAQActivity::class.java)
            startActivity(intent)
        }

        btnHelp.setOnClickListener {
            val intent = Intent(this.requireActivity(), DonationActivity::class.java)
            startActivity(intent)
        }


    }
}