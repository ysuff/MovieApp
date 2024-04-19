package com.yusuf.movieapp.model

import com.google.gson.annotations.SerializedName

data class SearchMovieDataClass(
    @SerializedName("id") val movieId: Int = 0,
    @SerializedName("title") val movieTitle: String = "",
    @SerializedName("popularity") val popularity: Double = 0.1,
    @SerializedName("poster_path") val posterPath: String = "",
)

data class SearchMovieResult(
    @SerializedName("page") val page: Int = 0,
    @SerializedName("results") val searchResults: List<SearchMovieDataClass>,

    )


