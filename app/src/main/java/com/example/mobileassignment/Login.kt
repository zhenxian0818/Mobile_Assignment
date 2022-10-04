package com.example.mobileassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.common.api.internal.RegisterListenerMethod
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth
    private lateinit var tfEmail : TextView
    private lateinit var tfPassword : TextView
    private lateinit var btnLogin : Button
    private lateinit var btnRegister : Button
    private lateinit var btnBack : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // authentication for login
        auth = FirebaseAuth.getInstance()

        btnLogin = findViewById(R.id.btnLogin)
        btnRegister = findViewById(R.id.btnRegister)
        tfEmail = findViewById(R.id.tfEmail)
        tfPassword= findViewById(R.id.tfPassword)
        btnBack = findViewById(R.id.btnBack)

        btnLogin.setOnClickListener {
            if (checking()) {
                val email = tfEmail.text.toString()
                val password = tfPassword.text.toString()
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            var intent = Intent(this, UserProfile::class.java)
                            intent.putExtra("Email", email)
                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(this, "Wrong Email or Password!", Toast.LENGTH_LONG).show()
                        }
                    }
            } else {
                Toast.makeText(this, "Email or Password is Empty!", Toast.LENGTH_LONG).show()
            }
        }

        btnRegister.setOnClickListener {
            var intent = Intent(this, Register::class.java)
            startActivity(intent)
            finish()
        }

        btnBack.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    private fun checking(): Boolean{
        if(tfEmail.text.toString().trim { it <= ' ' }.isNotEmpty()
            && tfPassword.text.toString().trim { it <= ' ' }.isNotEmpty()){
            return true
        }
        return false
    }


}