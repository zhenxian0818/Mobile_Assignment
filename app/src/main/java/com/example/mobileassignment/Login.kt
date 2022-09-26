package com.example.mobileassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth

    val tfEmail : TextView = findViewById(R.id.tfEmail)
    val tfPassword : TextView = findViewById(R.id.tfPassword)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // authentication for login
        auth = FirebaseAuth.getInstance()

        //val email : TextView = findViewById(R.id.tfEmail)
        //val password : TextView = findViewById(R.id.tfPassword)
        val btnLogin : Button = findViewById(R.id.btnLogin)
        val btnRegister : Button = findViewById(R.id.btnRegister)

        btnLogin.setOnClickListener {
            if(checking()){
                val email = tfEmail.text.toString()
                val password = tfPassword.text.toString()
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this){
                        task->
                        if(task.isSuccessful){
                            Toast.makeText(this, "Login Successful!", Toast.LENGTH_LONG).show()
                        }else{
                            Toast.makeText(this, "Wrong Email or Password!", Toast.LENGTH_LONG).show()
                        }
                    }
            }else{
                Toast.makeText(this, "Email or Password is Empty!", Toast.LENGTH_LONG).show()
            }
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