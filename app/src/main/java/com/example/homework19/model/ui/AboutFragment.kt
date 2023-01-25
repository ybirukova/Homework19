package com.example.homework19.model.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.homework19.R

class AboutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_about, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val about = view.findViewById<TextView>(R.id.tv_fragment_about)
        val title = view.findViewById<TextView>(R.id.tv_fragment_title)
        about.text = arguments?.getString(ABOUT_TEXT)
        title.text = arguments?.getString(TITLE_TEXT)
    }

    companion object {
        private val ABOUT_TEXT = "about"
        private val TITLE_TEXT = "title"

        fun newInstance(title: String, about: String): AboutFragment {
            val fragment = AboutFragment()
            val args: Bundle = Bundle()
            args.putString(ABOUT_TEXT, about)
            args.putString(TITLE_TEXT, title)
            fragment.arguments = args
            return fragment
        }
    }
}