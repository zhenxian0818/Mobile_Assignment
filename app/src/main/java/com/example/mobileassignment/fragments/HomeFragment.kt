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

    private lateinit var btnQuiz : Button
    private lateinit var btnHelp : Button
    private lateinit var btnNews : Button
    private lateinit var btnFaq : Button
    private lateinit var btnExit : Button
    private lateinit var btnAchievements : Button


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

        btnQuiz = view.findViewById(R.id.btnQuiz)
        btnHelp = view.findViewById(R.id.btnHelp)
        btnNews = view.findViewById(R.id.btnNews)
        btnFaq  = view.findViewById(R.id.btnFaq)
        btnExit = view.findViewById(R.id.btnExit)
        btnAchievements = view.findViewById(R.id.btnAchievements)

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

        btnAchievements.setOnClickListener {
            val intent = Intent(this.requireActivity(), AchievementsActivity::class.java)
            startActivity(intent)
        }
        btnExit.setOnClickListener {
            activity?.moveTaskToBack(true)
            activity?.finish()
        }


    }
}