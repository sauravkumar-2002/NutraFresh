package com.example.nutrafresh.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nutrafresh.R
import com.example.nutrafresh.adapters.fruits_adapter
import com.example.nutrafresh.models.url_model

class dashboard : AppCompatActivity() {
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: fruits_adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        var recv=findViewById<RecyclerView>(R.id.recv)
        loadRecView(recv);
    }

    private fun loadRecView(recv: RecyclerView?) {
        layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        adapter = fruits_adapter(this)
        if (recv != null) {
            recv.layoutManager = layoutManager
            recv.adapter = adapter
        }
         var url_list = mutableListOf<url_model>()
        url_list.add(url_model("f1","f2","f1_img","f2_img","f1_desc","f2_desc"));
        url_list.add(url_model("f1","f2","f1_img","f2_img","f1_desc","f2_desc"));
        url_list.add(url_model("f1","f2","f1_img","f2_img","f1_desc","f2_desc"));
        url_list.add(url_model("f1","f2","f1_img","f2_img","f1_desc","f2_desc"));
        url_list.add(url_model("f1","f2","f1_img","f2_img","f1_desc","f2_desc"));
        url_list.add(url_model("f1","f2","f1_img","f2_img","f1_desc","f2_desc"));
        url_list.add(url_model("f1","f2","f1_img","f2_img","f1_desc","f2_desc"));
        url_list.add(url_model("f1","f2","f1_img","f2_img","f1_desc","f2_desc"));
        url_list.add(url_model("f1","f2","f1_img","f2_img","f1_desc","f2_desc"));
        adapter.seturllist(url_list);
    }


}