package com.yusuf.movieapp.view

import FavoriteMovieAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yusuf.movieapp.data.MovieEntity
import com.yusuf.movieapp.data.MovieViewModel
import com.yusuf.movieapp.databinding.FragmentFavoriteFragmentsBinding


class FavoriteFragments : Fragment() {
    private lateinit var binding: FragmentFavoriteFragmentsBinding
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var favoriteMovieRecyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteFragmentsBinding.inflate(inflater, container, false)
        favoriteMovieRecyclerView = binding.favoriteMovieRecyclerView

        var favoriteViewDataSet = ArrayList<MovieEntity>()
        val favoriteViewAdapter = FavoriteMovieAdapter(favoriteViewDataSet)
        favoriteMovieRecyclerView.adapter = favoriteViewAdapter

        favoriteMovieRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this.context)
        }

        movieViewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
        movieViewModel.readAllData.observe(viewLifecycleOwner, Observer { movieList ->
            for (movie in movieList) {
                favoriteViewDataSet.add(movie)
            favoriteViewAdapter.notifyItemInserted(favoriteViewDataSet.indexOf(movie))
            }
            println(favoriteViewDataSet)

            favoriteViewAdapter.notifyDataSetChanged()

        })



        return binding.root
    }


}