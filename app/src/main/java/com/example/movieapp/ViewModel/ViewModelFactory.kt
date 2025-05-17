package com.example.movieapp.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class ViewModelFactory(private val repository: MovieRepository)
    : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieViewModel::class.java)){
            return MovieViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}