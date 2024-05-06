package com.yusuf.movieapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "movive_table")

data class MovieEntity(
    @PrimaryKey()
    val movieIdDb: Int,
    val movieTitle:String,
    val moviePhoto:String,
    val movieReleaseDate: String,
    val movieStarRate: Double,


    )
