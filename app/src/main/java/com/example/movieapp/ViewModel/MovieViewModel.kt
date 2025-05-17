package com.example.movieapp.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.api.RetrofitInstance
import com.example.movieapp.data.movie_data_class
import kotlinx.coroutines.launch

class MovieViewModel(private val respository: MovieRepository) : ViewModel() {
    private var movie_LiveData = MutableLiveData<List<movie_data_class.Result>>()
    fun getMovies() {
        viewModelScope.launch {
            val response = respository.getMovies()
            if (response.isSuccessful) {
                movie_LiveData.value = response.body()?.results
            } else {
                Log.e("API_ERROR", "Error: ${response.message()}")
            }
        }
    }

    fun observeMovieLiveData() : LiveData<List<movie_data_class.Result>> {
        return movie_LiveData
    }
}