package com.yusuf.movieapp

import com.google.gson.annotations.SerializedName

data class FavoriteMoviesDataClass(
    @SerializedName("id") var id: String,
    @SerializedName("original_title") var originalTitle: String,
    @SerializedName("popularity") var popularity: String
)
