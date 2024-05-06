package com.yusuf.movieapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addMovie(movieEntity: MovieEntity)

    @Query("SELECT * FROM movive_table WHERE movieIdDb = :movieId")
    fun getMovieById(movieId: Int): LiveData<MovieEntity?>
    @Query("SELECT * FROM movive_table ORDER BY movieIdDb")
    fun readAllData():LiveData<List<MovieEntity>>

    @Delete
    suspend fun deleteMovie(movie:MovieEntity)
    @Query("DELETE FROM movive_table")
    suspend fun deleteAllMovie()







}