package com.example.homework19.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homework19.databinding.RvMovieItemBinding
import com.example.homework19.domain.models.MovieData

class MovieAdapter(
    private val movieList: List<MovieData>,
    private val itemClick: (Int) -> Unit
) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RvMovieItemBinding.inflate(layoutInflater, parent, false)
        return MovieViewHolder(binding, itemClick)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.onBind(movieList[position])
    }

    override fun getItemCount(): Int = movieList.size

    inner class MovieViewHolder(
        private val binding: RvMovieItemBinding,
        private val itemClick: (Int) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(movie: MovieData) {
            binding.tvName.text = movie.name
            binding.ivIsOscar.isVisible = movie.isOscar
            binding.tvRating.text = movie.rating.toString()

            Glide
                .with(binding.root.context)
                .load(movie.imageStr)
                .into(binding.ivPoster)

            itemView.setOnClickListener {
                itemClick.invoke(adapterPosition)
            }
        }
    }
}