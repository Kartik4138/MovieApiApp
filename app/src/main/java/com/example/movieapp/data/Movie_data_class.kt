package com.example.movieapp.data

data class movie_data_class(
    val page: Int,
    val results: List<Result>
){
    data class Result(
        val backdrop_path: String,
        val overview: String,
        val title: String
    )
}