package com.example.movieapp.api

import com.example.movieapp.data.movie_data_class
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("now_playing")
    suspend fun getMovies(@Query("api_key") apiKey: String): Response<movie_data_class>
}