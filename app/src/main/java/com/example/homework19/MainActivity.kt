package com.example.homework19

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val movieList = Server.getMovie()

        val recycler = findViewById<RecyclerView>(R.id.rv_movie_list)

        val itemClick: (String, String) -> Unit = { title, about ->
            val newFragment = AboutFragment.newInstance(title, about)
            supportFragmentManager
                .beginTransaction()
                .add(R.id.about_fragment, newFragment)
                .commit()
            //Запуск фрагмента
        }

        val adapter = MovieAdapter(itemClick)
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapter.setItems(movieList)
    }
}