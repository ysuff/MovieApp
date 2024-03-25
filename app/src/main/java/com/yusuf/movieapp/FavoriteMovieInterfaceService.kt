package com.yusuf.movieapp
import retrofit2.http.GET
import retrofit2.http.Headers

interface FavoriteMovieInterfaceService {
    @GET("account/21107769/favorite/movies?language=en-US&page=1&sort_by=created_at.asc")
    @Headers("accept: application/json", "Authorization: Bearer <Your_API_Key>")
    suspend fun getFavoriteMovies(): List<FavoriteMoviesDataClass>
}



