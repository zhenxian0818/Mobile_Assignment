package com.example.mobileassignment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class DonationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donation)

        val cefDonate = findViewById<Button>(R.id.cefDonateButton)
        val rainDonate = findViewById<Button>(R.id.rainDonateButton)
        val evergreenDonate = findViewById<Button>(R.id.evergreenDonateButton)
        val home = findViewById<Button>(R.id.homeDonateButton)

        cefDonate.setOnClickListener {
            val url = "https://www.climateemergencyfund.org/?form=donate"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        rainDonate.setOnClickListener {
            val url = "https://rainforestfoundation.org/?form=donate"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        evergreenDonate.setOnClickListener {
            val url = "https://secure.actblue.com/donate/evergreenaction?refcode=alertbar"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        home.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }
}