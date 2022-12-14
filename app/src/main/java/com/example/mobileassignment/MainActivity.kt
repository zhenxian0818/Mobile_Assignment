package com.example.mobileassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.mobileassignment.fragments.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private val dailyTaskFragment = DailyTaskFragment()
    private val homeFragment = HomeFragment()

    lateinit var bottom_navigation : BottomNavigationView


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
                R.id.ic_user_profile->{
                    if(!isLogin()){
                        val intent = Intent(this, Login::class.java)
                        startActivity(intent)
                    }
                    else{
                        val intent = Intent(this, UserProfile::class.java)
                        startActivity(intent)
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