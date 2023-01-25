package com.example.homework19.model.ui

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homework19.R

class MovieViewHolder(itemView: View, private val itemCLick: (String, String) -> Unit) :
    RecyclerView.ViewHolder(itemView) {

    fun onBind(movie: MovieData) {
        val itemClick = this.itemCLick
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
            itemClick.invoke(movie.name, movie.about)
        }
    }
}