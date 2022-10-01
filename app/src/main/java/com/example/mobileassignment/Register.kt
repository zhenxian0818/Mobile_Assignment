package com.example.mobileassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Register : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

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


        btnSignup.setOnClickListener {
            if(checking()){

                //variable that store in firebase
                var email = registerEmail.text.toString()
                var password = registerPassword.text.toString()
                var username = registerUsername.text.toString()
                var ic = registerIc.text.toString()

                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this){
                        task->
                        if(task.isSuccessful){
                            Toast.makeText(this, "Register Successfully!", Toast.LENGTH_LONG).show()
                        }else{
                            Toast.makeText(this, "Register Failed!", Toast.LENGTH_LONG).show()
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