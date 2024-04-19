package com.yusuf.movieapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MovieEntity::class], version = 1, exportSchema = false)
abstract class MovieDataBase:RoomDatabase() {

    abstract fun movideDao():MovieDao

    companion object{
        @Volatile
        private  var INSTANCE:MovieDataBase?=null

        fun getDatabase(context: Context):MovieDataBase{
            val tempInstance=INSTANCE
            if (tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance=Room.databaseBuilder(
                    context.applicationContext,
                    MovieDataBase::class.java,
                    "movie_database"
                ).build()
                INSTANCE=instance
                return instance
            }
        }
    }
}