package com.example.homework19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val androidList = Server.getMovie()

        val recycler = findViewById<RecyclerView>(R.id.rvAndroidList)
        val adapter = AndroidAdapter()
        recycler.adapter = adapter
        recycler.layoutManager =LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false)
        adapter.setItems(androidList)
    }
}