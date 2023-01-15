package com.example.homework19

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AndroidAdapter :
    RecyclerView.Adapter<AndroidViewHolder>() {
    private val list: MutableList<Movie> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AndroidViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.rv_movie_item, parent, false)
        return AndroidViewHolder(view)
    }

    override fun onBindViewHolder(holder: AndroidViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun setItems(list: List<Movie>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }
}