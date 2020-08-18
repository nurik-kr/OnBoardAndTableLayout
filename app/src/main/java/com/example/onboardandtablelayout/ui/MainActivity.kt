package com.example.onboardandtablelayout.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.onboardandtablelayout.R
import com.example.onboardandtablelayout.ui.Fragment.FragmentHome
import com.example.onboardandtablelayout.ui.Fragment.FragmentShop
import com.example.onboardandtablelayout.ui.Fragment.FragmentPhoto
import com.example.onboardandtablelayout.ui.Fragment.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBottomNav()
        setupListeners()
    }

    private fun setupBottomNav() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        ViewPager.adapter = adapter
        adapter.addFragment(FragmentHome())
        adapter.addFragment(FragmentPhoto())
        adapter.addFragment(FragmentShop())
    }

    private fun setupListeners() {
        bottomNav.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.home -> ViewPager.currentItem = 0
                R.id.photo -> ViewPager.currentItem = 1
                R.id.shop -> ViewPager.currentItem = 2
            }
            true
        }
    }
}