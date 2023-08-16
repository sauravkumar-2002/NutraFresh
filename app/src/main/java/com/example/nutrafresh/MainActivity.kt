package com.example.nutrafresh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
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
    }
}//oouu