package com.example.homework19

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.homework19.model.ui.movie_details.AboutFragment
import com.example.homework19.model.ui.movies_list.MovieFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemClick: (String, String) -> Unit = { title, about ->
            openFragment(AboutFragment.newInstance(title, about), true)
        }

        openFragment(MovieFragment.newInstance(itemClick), false)
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