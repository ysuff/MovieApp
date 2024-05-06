package com.yusuf.movieapp.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieViewModel (application: Application):AndroidViewModel(application) {

      val readAllData : LiveData<List<MovieEntity>>
    private val repository:MovieRepository

    init {
        val movieDao=MovieDataBase.getDatabase(application).movideDao()
        repository= MovieRepository(movieDao)
        readAllData=repository.readAllData
    }

    fun addMovie(movieEntity: MovieEntity){
        viewModelScope.launch ( Dispatchers.IO){
            repository.addMovie(movieEntity)
        }
    }
    fun getMovieById(movieId: Int): LiveData<MovieEntity?> {
        return repository.getMovieById(movieId)
    }


    fun deleteMovie(movie: MovieEntity){
        viewModelScope.launch ( Dispatchers.IO) {
            repository.deleteMovie(movie)
        }

    }
    fun deleteAllMovie(){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteAllMovie()
        }
    }

}