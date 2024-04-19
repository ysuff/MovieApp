package com.yusuf.movieapp.services

import com.yusuf.movieapp.model.SearchMovieResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface SearchMovieGetService {
    @Headers(
        "Accept: application/json",
        "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJjZDdhMDZhMmVjMTU4MWQ5NjE5ZDQ0NzY4YWM3NDFjMyIsInN1YiI6IjY1ZjU5Zjc4ZDRhNjhiMDE3ZjI4YzI4YiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.985K5kGcCBJRYZP4dQEdF90wdEgmVbwiOrmsjSf3k5U",
    )
    @GET("search/movie")


    fun get(@Query("query")movieId:String): Call<SearchMovieResult>
}