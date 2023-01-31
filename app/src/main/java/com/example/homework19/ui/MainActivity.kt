package com.example.homework19.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.homework19.R
import com.example.homework19.ui.all_movies.MovieFragment
import com.example.homework19.ui.movie_details.AboutFragment
import com.example.homework19.ui.unpopular_movies.UnpopularMovieFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemClick: (String, String) -> Unit = { title, about ->
            openFragment(AboutFragment.newInstance(title, about), true)
        }

        val onUnpopularButtonClick: () -> Unit = {
            openFragment(UnpopularMovieFragment.newInstance(), true)
        }
        openFragment(MovieFragment.newInstance(itemClick, onUnpopularButtonClick), false)
    }

    private fun openFragment(fragment: Fragment, addToBackStack: Boolean) {

        val transaction = supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)

        if (addToBackStack) {
            transaction.addToBackStack(null)
        }
        transaction.commit()
    }
}