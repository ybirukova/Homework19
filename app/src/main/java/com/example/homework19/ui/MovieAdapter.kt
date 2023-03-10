package com.example.homework19.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homework19.R
import com.example.homework19.domain.models.MovieData

class MovieAdapter(
    private val movieList: List<MovieData>,
    private val itemClick: (Int) -> Unit
) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.rv_movie_item, parent, false)
        return MovieViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.onBind(movieList[position])
    }

    override fun getItemCount(): Int = movieList.size

    inner class MovieViewHolder(
        itemView: View,
        private val itemClick: (Int) -> Unit
    ) :
        RecyclerView.ViewHolder(itemView) {

        fun onBind(movie: MovieData) {
            val poster = itemView.findViewById<ImageView>(R.id.iv_poster)
            val name = itemView.findViewById<TextView>(R.id.tv_name)
            val oscar = itemView.findViewById<ImageView>(R.id.iv_is_oscar)
            val rating = itemView.findViewById<TextView>(R.id.tv_rating)

            name.text = movie.name
            oscar.isVisible = movie.isOscar
            rating.text = movie.rating.toString()

            Glide
                .with(itemView.context)
                .load(movie.imageStr)
                .into(poster)

            itemView.setOnClickListener {
                itemClick.invoke(adapterPosition)
            }
        }
    }
}