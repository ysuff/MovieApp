package com.yusuf.movieapp

import android.graphics.pdf.PdfDocument.Page
import com.google.gson.annotations.SerializedName

data class GetDataClass(
    @SerializedName("id") val movieId:Int=0,
    @SerializedName("title") val originalTitle:String="",
    @SerializedName("popularity") val popularity:Double=0.1,
    @SerializedName("poster_path") val posterPath:String="",
)

data class Resault(
    @SerializedName("page") val page:Int=0,
    @SerializedName("results") val results:List<GetDataClass>,

)


