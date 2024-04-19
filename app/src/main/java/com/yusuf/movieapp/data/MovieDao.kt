package com.yusuf.movieapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addMovie(movieEntity: MovieEntity)


    @Query("SELECT * FROM movive_table ORDER BY movieIdDb")
    fun readAllData():LiveData<List<MovieEntity>>
}