package com.yusuf.movieapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "movive_table")

data class MovieEntity(
    @PrimaryKey(autoGenerate = true)
    val movieIdDb : Int,
    val movieNameDb:String,

)
