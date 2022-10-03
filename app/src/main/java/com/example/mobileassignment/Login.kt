package com.example.mobileassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.mobileassignment.fragments.UserProfileFragment
import com.google.android.gms.common.api.internal.RegisterListenerMethod
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth
    private lateinit var tfEmail : TextView
    private lateinit var tfPassword : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // authentication for login
        auth = FirebaseAuth.getInstance()

        val btnLogin : Button = findViewById(R.id.btnLogin)
        val btnRegister : Button = findViewById(R.id.btnRegister)
        tfEmail = findViewById(R.id.tfEmail)
        tfPassword= findViewById(R.id.tfPassword)

        btnLogin.setOnClickListener {
            if (checking()) {
                val email = tfEmail.text.toString()
                val password = tfPassword.text.toString()
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            var intent = Intent(this, UserProfileFragment::class.java)
                            intent.putExtra("email", email)
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

    }

    private fun checking(): Boolean{
        if(tfEmail.text.toString().trim { it <= ' ' }.isNotEmpty()
            && tfPassword.text.toString().trim { it <= ' ' }.isNotEmpty()){
            return true
        }
        return false
    }


}