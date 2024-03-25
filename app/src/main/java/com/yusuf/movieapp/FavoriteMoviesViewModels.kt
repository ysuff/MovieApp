package com.yusuf.movieapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FavoriteMoviesViewModels {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val apiService = retrofit.create(FavoriteMovieInterfaceService::class.java)

    suspend fun fetchMovies(): List<FavoriteMoviesDataClass> {
        return apiService.getFavoriteMovies()
    }
}







