package com.example.mobileassignment

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import org.w3c.dom.Text

class UserProfile : AppCompatActivity() {

    private lateinit var db : FirebaseFirestore

    private lateinit var btnSignOut : Button
    private lateinit var btnHome : Button
    private lateinit var tvUserName : TextView
    private lateinit var tvUserEmail : TextView
    private lateinit var tvUserIc : TextView

    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        val sharePref = this?.getPreferences(Context.MODE_PRIVATE)?:return
        val logged = sharePref.getString("Email", "1")

        if(logged == "1"){

            var email = intent.getStringExtra("Email")
            if(email != null){
                setText(email)
                with(sharePref.edit()){
                    putString("Email", email)
                    apply()
                }
            }else{
                val intent = Intent(this, Login::class.java)
                startActivity(intent)
                finish()
            }

        }else{
            setText(logged)
        }


        btnSignOut = findViewById(R.id.userProfLogOutBtn)
        btnHome = findViewById(R.id.userProfHomeBtn)

        auth = FirebaseAuth.getInstance()

        btnSignOut.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)

            startActivity(intent)
            auth.signOut()
        }

        btnHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    private fun setText(email:String?){

        tvUserName = findViewById(R.id.tvUserName)
        tvUserEmail = findViewById(R.id.tvUserEmail)
        tvUserIc = findViewById(R.id.tvUserIc)

        db = FirebaseFirestore.getInstance()
        if (email != null) {
            db.collection("USERS").document(email).get()
                .addOnSuccessListener { tasks->
                    tvUserEmail.text = tasks.get("Email").toString()
                    tvUserIc.text = tasks.get("Ic").toString()
                    tvUserName.text = tasks.get("Username").toString()
                }
        }
    }
}