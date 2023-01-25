package com.example.homework19

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework19.model.ui.MovieData
import com.example.homework19.model.ui.MovieViewHolder

class MovieAdapter(
    private val movieList: List<MovieData>,
    private val itemCLick: (String, String) -> Unit
) :
    RecyclerView.Adapter<MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.rv_movie_item, parent, false)
        return MovieViewHolder(view, itemCLick)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.onBind(movieList[position])
    }

    override fun getItemCount(): Int = movieList.size
}