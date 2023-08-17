package com.example.nutrafresh.Register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.nutrafresh.R
import com.example.nutrafresh.dashboard.dashboard

class Resister : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resister)
        var skpbtn=findViewById<Button>(R.id.send_otp)
        skpbtn.setOnClickListener {
            var intent = Intent(this, dashboard::class.java)
            startActivity(intent)
        }
    }
}