package com.example.mobileassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.mobileassignment.fragments.HomeFragment
import com.example.mobileassignment.fragments.UserProfileFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class Register : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    private lateinit var registerEmail : TextView
    private lateinit var registerPassword : TextView
    private lateinit var registerUsername : TextView
    private lateinit var registerIc : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val btnSignup : Button = findViewById(R.id.btnSignup)
        registerEmail = findViewById(R.id.tfRegisterEmail)
        registerPassword = findViewById(R.id.tfRegisterPassword)
        registerUsername = findViewById(R.id.tfRegisterUsername)
        registerIc = findViewById(R.id.tfRegisterIc)

        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        btnSignup.setOnClickListener {
            if(checking()){

                //variable that store in firebase
                var email = registerEmail.text.toString()
                var password = registerPassword.text.toString()
                var username = registerUsername.text.toString()
                var ic = registerIc.text.toString()

                val user = hashMapOf(
                    "Username" to username,
                    "IC" to ic,
                    "email" to email
                )

                val Users = db.collection("USERS")
                val query = Users.whereEqualTo("email", email).get()
                    .addOnSuccessListener {
                        tasks->
                        if(tasks.isEmpty){
                            auth.createUserWithEmailAndPassword(email, password)
                                .addOnCompleteListener(this){
                                    task->
                                    if(task.isSuccessful){
                                        Users.document(email).set(user)
                                        val intent = Intent(this, UserProfileFragment::class.java)
                                        startActivity(intent)
                                        finish()
                                    }else{
                                        Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show()
                                    }
                                }
                        }else{
                            Toast.makeText(this, "User already exists!", Toast.LENGTH_LONG).show()
                            val intent = Intent(this, Login::class.java)
                            startActivity(intent)
                        }
                    }
            }else{
                Toast.makeText(this, "Your Details is Empty", Toast.LENGTH_LONG).show()
            }
        }

    }

    private fun checking(): Boolean{

        if(registerEmail.text.toString().trim { it<=' ' }.isNotEmpty()
            && registerPassword.text.toString().trim { it<=' ' }.isNotEmpty()
            && registerUsername.text.toString().trim { it<=' ' }.isNotEmpty()
            && registerIc.text.toString().trim { it<=' ' }.isNotEmpty()
        )
        {
            return true
        }
        return false
    }
}