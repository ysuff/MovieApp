package com.yusuf.movieapp.viewmodel

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object SearchMovieApiClient {
    private var retrofit: Retrofit? = null

    fun getClient(): Retrofit {
        if (retrofit == null)
            retrofit = Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        return retrofit as Retrofit

    }


}