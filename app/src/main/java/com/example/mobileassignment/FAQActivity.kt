package com.example.mobileassignment

import android.content.Intent
import android.graphics.Color
import android.graphics.Paint
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class FAQActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private lateinit var faqSourceLink : TextView
    private lateinit var faqSpinner : Spinner
    private lateinit var faqAns : TextView
    private lateinit var btnFaqHome : Button

    private lateinit var faqListAns : Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faqactivity)

        btnFaqHome = findViewById(R.id.btnFaqHome)

        faqSourceLink = findViewById(R.id.faqSourceURL)
        faqSpinner = findViewById(R.id.faqSpinnerQ)
        faqAns = findViewById(R.id.faqAnswerTv)
        faqListAns = resources.getStringArray(R.array.faqspinner_a)

        faqSourceLink.setTextColor(Color.BLUE)
        faqSourceLink.paintFlags = Paint.UNDERLINE_TEXT_FLAG
        faqSourceLink.setOnClickListener{

            startActivity(Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.nature.org/en-us/what-we-do/our-priorities/tackle-climate-change/climate-change-stories/climate-change-frequently-asked-questions/#crisis")))

        }

        // Back Button
        btnFaqHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        ArrayAdapter.createFromResource(
            this,
            R.array.faqspinner_q,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            faqSpinner.adapter = adapter
        }
        faqSpinner.onItemSelectedListener = this
    }

    override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
            when(position){
                0 -> faqAns.text =faqListAns[position]

                1 -> faqAns.text =faqListAns[position]

                2 -> faqAns.text =faqListAns[position]

                3 -> faqAns.text =faqListAns[position]

                4 -> faqAns.text =faqListAns[position]

                5 -> faqAns.text =faqListAns[position]

                6 -> faqAns.text =faqListAns[position]

                7 -> faqAns.text =faqListAns[position]

                8 -> faqAns.text =faqListAns[position]
            }

        }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        faqAns.text = ""
    }
}
