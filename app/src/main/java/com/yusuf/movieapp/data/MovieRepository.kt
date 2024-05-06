package com.yusuf.movieapp.data

import androidx.lifecycle.LiveData

class MovieRepository (private val movieDao: MovieDao){
    val readAllData:LiveData<List<MovieEntity>> = movieDao.readAllData()

             fun addMovie(movieEntity: MovieEntity){
                movieDao.addMovie(movieEntity)
            }


     fun getMovieById(movieId: Int): LiveData<MovieEntity?> {
        return movieDao.getMovieById(movieId)
    }
    suspend fun deleteMovie(movie:MovieEntity){
        movieDao.deleteMovie(movie)
    }
    suspend fun deleteAllMovie(){
        movieDao.deleteAllMovie()
    }
}