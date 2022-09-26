package com.example.mobileassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mobileassignment.fragments.DailyTaskFragment
import com.example.mobileassignment.fragments.HomeFragment
import com.example.mobileassignment.fragments.SetGoalFragment
import com.example.mobileassignment.fragments.UserProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.internal.NavigationMenu
import com.google.android.material.internal.NavigationMenuItemView
import com.google.android.material.internal.NavigationMenuView

class MainActivity : AppCompatActivity() {

    private val dailyTaskFragment = DailyTaskFragment()
    private val setGoalFragment = SetGoalFragment()
    private val userProfileFragment = UserProfileFragment()
    private val homeFragment = HomeFragment()

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
                R.id.ic_set_goal->replaceFragment(setGoalFragment)
                R.id.ic_user_profile->{

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
}