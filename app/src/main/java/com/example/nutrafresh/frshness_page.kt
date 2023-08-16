package com.example.nutrafresh

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.nutrafresh.dashboard.dashboard
import com.google.android.material.floatingactionbutton.FloatingActionButton


class frshness_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frshness_page)
        setupFloatingActionButton()
        val byteArray = intent.getByteArrayExtra("image")
        val bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray!!.size)
        var img=findViewById<ImageView>(R.id.ft_img)
        img.setImageBitmap(bitmap)
    }
    private fun setupFloatingActionButton() {
        var fab=findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            // We are showing only toast message. However, you can do anything you need.
            var intent= Intent(this, dashboard::class.java)
            startActivity(intent)
        }
    }
}