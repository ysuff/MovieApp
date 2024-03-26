package com.yusuf.movieapp
import retrofit2.http.GET
import retrofit2.http.Headers

interface FavoriteMovieInterfaceService {
    @GET("favorite/movies")
    @Headers("accept: application/json", "Authorization: Bearer <Your_API_Key>")
    suspend fun getFavoriteMovies(): List<FavoriteMoviesDataClass>
}



