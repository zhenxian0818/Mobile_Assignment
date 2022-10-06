package com.example.mobileassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class Register : AppCompatActivity() {

    // Global Variable
    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    private lateinit var registerEmail : TextView
    private lateinit var registerPassword : TextView
    private lateinit var registerUsername : TextView
    private lateinit var registerIc : TextView
    
    private lateinit var emailContainer : TextInputLayout
    private lateinit var passwordContainer : TextInputLayout
    private lateinit var usernameContainer : TextInputLayout
    private lateinit var icContainer : TextInputLayout
    
            
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Button
        val btnSignup : Button = findViewById(R.id.btnSignup)
        val btnRegBack : Button = findViewById(R.id.btnRegBack)

        // Variable Declaration
        registerEmail = findViewById(R.id.tfRegisterEmail)
        registerPassword = findViewById(R.id.tfRegisterPassword)
        registerUsername = findViewById(R.id.tfRegisterUsername)
        registerIc = findViewById(R.id.tfRegisterIc)

        // Firebase
        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        // Validation Checking
        emailFocusListener()
        passwordFocusListener()
        usernameFocusListener()
        icFocusListener()
        
        btnSignup.setOnClickListener {
            if(checking()){

                //variable that store in firebase
                var email = registerEmail.text.toString()
                var password = registerPassword.text.toString()
                var username = registerUsername.text.toString()
                var ic = registerIc.text.toString()

                val user = hashMapOf(
                    "Username" to username,
                    "Ic" to ic,
                    "Email" to email
                )
                val Users = db.collection("USERS")
                val query = Users.whereEqualTo("Email", email).get()
                    .addOnSuccessListener {
                        tasks->
                        if(tasks.isEmpty){

                            auth.createUserWithEmailAndPassword(email, password)
                                .addOnCompleteListener(this){
                                    task->
                                    if(task.isSuccessful){

                                        Users.document(email).set(user)
                                        val intent = Intent(this, Login::class.java)
                                        intent.putExtra("Email", email)
                                        startActivity(intent)
                                        finish()

                                    }else{
                                        Toast.makeText(this, "Your Details is not Incompleted!", Toast.LENGTH_LONG).show()
                                    }
                                }

                        }else{
                            Toast.makeText(this, "This User is Existed!", Toast.LENGTH_LONG).show()
                            val intent = Intent(this, Login::class.java)
                            startActivity(intent)
                        }
                    }

            }else{
                Toast.makeText(this, "Your Details is Empty", Toast.LENGTH_LONG).show()
            }
        }

        btnRegBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    private fun emailFocusListener() {
        
        emailContainer = findViewById(R.id.emailContainer)
        
        registerEmail.setOnFocusChangeListener{_, focused ->
            if(!focused){
                emailContainer.helperText = validEmail()
            }
        }
    }

    private fun validEmail(): String? {

        val tfEmail = registerEmail.text.toString()
        if(!Patterns.EMAIL_ADDRESS.matcher(tfEmail).matches()){
            return "Invalid Email Address"
        }

        return null
    }

    private fun passwordFocusListener(){

        passwordContainer = findViewById(R.id.passwordContainer)

        registerPassword.setOnFocusChangeListener{_, focused->
            passwordContainer.helperText = validPassword()
        }
    }

    private fun validPassword(): String? {

        val tfPassword = registerPassword.text.toString()

        if(tfPassword.length < 8){
            return "At least 8 character for password"
        }
        if(!tfPassword.matches(".*[A-Z].*".toRegex())){
            return "Password must contain at least 1 Upper-case"
        }
        if(!tfPassword.matches(".*[a-z].*".toRegex())){
            return "Password must contain at least 1 Lower-case"
        }

        return null
    }

    private fun usernameFocusListener(){
        usernameContainer = findViewById(R.id.usernameContainer)

        registerUsername.setOnFocusChangeListener { _, focused ->
            usernameContainer.helperText = validUsername()
        }
    }

    private fun validUsername(): String? {

        val tfUsername = registerUsername.text.toString()

        if(tfUsername.length < 5){
            return "Username should contain at least 5 characters"
        }

        return null
    }

    private fun icFocusListener(){

        icContainer = findViewById(R.id.icContainer)

        registerIc.setOnFocusChangeListener{_, focused->
            icContainer.helperText = validIc()
        }
    }

    private fun validIc(): String? {

        val tfIc = registerIc.text.toString()

        if(!tfIc.matches("/^[0-9]{6}-[0-9]{2}-[0-9]{4}\$/".toRegex())){
            return "Wrong IC Format"
        }

        return null
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