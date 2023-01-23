package com.example.homework19

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter (private val itemCLick: (String, String) -> Unit) :
    RecyclerView.Adapter<MovieViewHolder>() {
    private val list: MutableList<Movie> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.rv_movie_item, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.onBind(list[position], itemCLick)
    }

    override fun getItemCount(): Int = list.size

    fun setItems(list: List<Movie>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }
}