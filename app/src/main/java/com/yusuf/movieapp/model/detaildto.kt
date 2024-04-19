package com.yusuf.movieapp.model

import com.google.gson.annotations.SerializedName


data class DetailDtoResult(
    @SerializedName("id") var id: Int = 0,
    @SerializedName("overview") var detailOverView: String = "",
    @SerializedName("backdrop_path") var posterPath: String? = "",
    @SerializedName("release_date") var detailReleaseDate: String = "",
    @SerializedName("title") var detailTitle: String? = "",
    @SerializedName("vote_average") var detailVoteAverage: Double? = 0.1
       )

