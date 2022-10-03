package com.example.demobuttonmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val messageFragment = MessageFragment()
        val homeFragment = HomeFragment()
        val profileFragment = ProfileFragment()
        val bottomNavigationView=findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.miHome->setCurrentFragment(homeFragment)
                R.id.miMessage->setCurrentFragment(messageFragment)
                R.id.miProlie->setCurrentFragment(profileFragment)

            }
            true

        }
        bottomNavigationView.getOrCreateBadge(R.id.miMessage).apply {
            number = 10
            isVisible = true
        }
        bottomNavigationView.getOrCreateBadge(R.id.miHome).apply {
            number = 2
            isVisible = true
        }

    }
    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,fragment)
            addToBackStack(null)
            commit()
        }
}