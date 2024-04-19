package com.yusuf.movieapp.data

import androidx.lifecycle.LiveData

class MovieRepository (private val movieDao: MovieDao){
    val readAllData:LiveData<List<MovieEntity>> = movieDao.readAllData()

             fun addMovie(movieEntity: MovieEntity){
                movieDao.addMovie(movieEntity)
            }
}