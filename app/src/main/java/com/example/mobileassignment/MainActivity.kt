package com.example.mobileassignment

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.mobileassignment.fragments.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private val dailyTaskFragment = DailyTaskFragment()
    private val setGoalFragment = SetGoalFragment()
    private val userProfileFragment = UserProfileFragment()
    private val homeFragment = HomeFragment()
    private val loginFragment = LoginFragment()

    lateinit var bottom_navigation : BottomNavigationView

    private lateinit var email : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_navigation = findViewById(R.id.bottom_navigation)

        bottom_navigation.selectedItemId = R.id.ic_home_page
        replaceFragment(homeFragment)
    }

    override fun onResume() {
        super.onResume()

        bottom_navigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.ic_home_page->replaceFragment(homeFragment)
                R.id.ic_daily_task->replaceFragment(dailyTaskFragment)
                R.id.ic_news->startActivity(Intent(this, News::class.java))
                R.id.ic_quiz_page->startActivity(Intent(this, QuizGameActivity::class.java))
                R.id.ic_user_profile->{
                    if(!isLogin()){
                        replaceFragment(loginFragment)
                    }
                    else{
                        replaceFragment(userProfileFragment)
                    }
                }
            }
            true
        }
    }

    private fun replaceFragment(fragment : Fragment){
        if(fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
        }
    }

    private fun isLogin():Boolean{
        val authLogged = FirebaseAuth.getInstance().currentUser
        return authLogged != null
    }
}