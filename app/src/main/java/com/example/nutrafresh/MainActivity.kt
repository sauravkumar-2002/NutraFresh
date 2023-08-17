package com.example.nutrafresh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import com.example.nutrafresh.Register.Resister
import com.example.nutrafresh.dashboard.dashboard
import com.example.nutrafresh.launcher.IntroSlide
import com.example.nutrafresh.launcher.IntroSliderAdapter

class MainActivity : AppCompatActivity() {
    private val introSliderAdapter=IntroSliderAdapter(
        listOf(
            IntroSlide(
                "Freshness",
                "Your Trusted Freshness Indicator for Fruits and Vegetables",
                R.drawable.freshness
            ),
        IntroSlide(
                    "Storage",
            "Providing You with Optimal Storage Conditions Measures",
            R.drawable.storage
        ),
        IntroSlide(
            "Nutrition",
        "Your Go-To Source for Accurate and Comprehensive Nutrition Information",
            R.drawable.nutrition
        )
        )
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val introSlideViewPager=findViewById<ViewPager2>(R.id.introSliderViewPager)
        introSlideViewPager.adapter=introSliderAdapter
        var skpbtn=findViewById<TextView>(R.id.skipBtn)
        skpbtn.setOnClickListener {
            var intent = Intent(this, Resister::class.java)
            startActivity(intent)
        }
    }
}//oouu