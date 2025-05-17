package com.example.movieapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.movieapp.ViewModel.MovieRepository
import com.example.movieapp.ViewModel.MovieViewModel
import com.example.movieapp.ViewModel.ViewModelFactory
import com.example.movieapp.adapter.RvAdapter
import com.example.movieapp.databinding.ActivityMainBinding
import com.example.movieapp.databinding.ItemMoviesBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MovieViewModel
    private lateinit var adapter: RvAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory = ViewModelFactory(MovieRepository())

        viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]
        viewModel.getMovies()
        viewModel.observeMovieLiveData().observe(this) { movieList ->
            movieList?.let {
                adapter.setMovieList(it)
            }
        }
        setRecyclerView()
    }

    private fun setRecyclerView() {
        adapter = RvAdapter()
        binding.rvMovies.layoutManager = LinearLayoutManager(this)
        binding.rvMovies.adapter = adapter
        }
    }