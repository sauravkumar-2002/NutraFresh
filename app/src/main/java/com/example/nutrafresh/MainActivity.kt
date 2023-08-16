package com.example.nutrafresh

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.nutrafresh.dashboard.dashboard


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var xx=findViewById<TextView>(R.id.check);
        xx.setOnClickListener {
            var intent = Intent(this, dashboard::class.java)
            startActivity(intent)
        }

    }
}//oo
