package com.example.mobileassignment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class FAQActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private lateinit var faqSourceLink : TextView
    private lateinit var faqSpinner : Spinner
    private lateinit var faqAns : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faqactivity)

        faqSourceLink = findViewById(R.id.faqSourceURL)
        faqSpinner = findViewById(R.id.faqSpinnerQ)
        faqAns = findViewById(R.id.faqAnswerTv)

        faqSourceLink.setOnClickListener{
            startActivity(Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.nature.org/en-us/what-we-do/our-priorities/tackle-climate-change/climate-change-stories/climate-change-frequently-asked-questions/#crisis")))
        }
        ArrayAdapter.createFromResource(
            this,
            R.array.faqspinner_q,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            faqSpinner.adapter = adapter
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        if (parent != null) {
            ArrayAdapter.createFromResource(
                this,
                R.array.faqspinner_a,
                android.R.layout.simple_spinner_item
            )
            faqAns.text = parent.getItemAtPosition(position).toString()


        }
    }


    override fun onNothingSelected(parent: AdapterView<*>?) {
        faqAns.text = ""
    }


}