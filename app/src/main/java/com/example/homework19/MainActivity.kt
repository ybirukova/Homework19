package com.example.homework19

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.homework19.model.ui.AboutFragment
import com.example.homework19.model.ui.MovieFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemClick: (String, String) -> Unit = { title, about ->
            val newFragment = AboutFragment.newInstance(title, about)
            supportFragmentManager
                .beginTransaction()
                .add(R.id.about_fragment, newFragment)
                .addToBackStack("")
                .commit()
        }

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fr_movie, MovieFragment(itemClick))
            .commit()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 0)
            super.onBackPressed()
        else supportFragmentManager.popBackStack()
    }
}