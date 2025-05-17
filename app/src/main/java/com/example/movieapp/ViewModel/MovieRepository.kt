package com.example.movieapp.ViewModel

import com.example.movieapp.api.RetrofitInstance
import com.example.movieapp.data.movie_data_class
import retrofit2.Response

class MovieRepository {

    suspend fun getMovies(): Response<movie_data_class> {

        return RetrofitInstance.api.getMovies("38a73d59546aa378980a88b645f487fc")
    }
}
