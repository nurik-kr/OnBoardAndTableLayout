package com.example.onboardandtablelayout.OnBoard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.onboardandtablelayout.Data.OnBoardModel
import com.example.onboardandtablelayout.R
import com.example.onboardandtablelayout.ui.MainActivity
import kotlinx.android.synthetic.main.activity_on_board_activtiy.*

class OnBoardActivtiy : AppCompatActivity() {
    private val list = arrayListOf<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_board_activtiy)
        setupListeners()
        setupViewPager()
    }

    private fun setupListeners() {
        onBoardViewPager.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                if (isLastPage(position)) {
                    btnNext.text = "Начать"
                } else {
                    btnNext.text = "Продолжить"
                }
            }
        })

        btnNext.setOnClickListener {
            if (isLastPage(onBoardViewPager.currentItem)) {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
//                onBoardViewPager.currentItem = onBoardViewPager.currentItem + 1
                onBoardViewPager.currentItem += 1
            }
        }
    }

    private fun isLastPage(position: Int) = position == list.size - 1

    private fun setupViewPager() {
        val adapter = OnBoardAdapter(supportFragmentManager)
        onBoardViewPager.adapter = adapter

        list.add(OnBoardFragment.getInstance(OnBoardModel(R.drawable.vita, "Добро пожаловать в наш магазин", "MY STYLE VITA")))
        list.add(OnBoardFragment.getInstance(OnBoardModel(R.drawable.vita, "В нашем магазине вы можете найти качественную одежду", "MY STYLE VITA")))
        list.add(OnBoardFragment.getInstance(OnBoardModel(R.drawable.dostavka, "У нас есть доставка по городу Бесплатная", "+996 508-170-177")))
        list.add(OnBoardFragment.getInstance(OnBoardModel(R.drawable.images, "Зарегистрируйтесь и пользуйтесь на здоровье", "С уважение MY STYLE VITA")))
        adapter.update(list)
        onBoardTabLayout.setupWithViewPager(onBoardViewPager)
    }
}