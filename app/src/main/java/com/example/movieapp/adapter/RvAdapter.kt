package com.example.movieapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.data.movie_data_class
import com.example.movieapp.databinding.ItemMoviesBinding

class RvAdapter : RecyclerView.Adapter<RvAdapter.RvViewHolder>() {
    class RvViewHolder(val binding: ItemMoviesBinding)
        :RecyclerView.ViewHolder(binding.root){}

    private var movie_list = ArrayList<movie_data_class.Result>()

    fun setMovieList(movieList : List<movie_data_class.Result>){
        this.movie_list = movieList as ArrayList<movie_data_class.Result>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvViewHolder {
        val binding = ItemMoviesBinding
            .inflate(LayoutInflater.from(
                parent.context
            ))

        return RvViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movie_list.size
    }

    override fun onBindViewHolder(holder: RvViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load("https://image.tmdb.org/t/p/w500"+movie_list[position].backdrop_path)
            .into(holder.binding.ivthumbnail)
        holder.binding.TvTitle.text = movie_list[position].title
        holder.binding.TvDescription.text = movie_list[position].overview
    }
}