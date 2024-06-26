package com.yusuf.movieapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.yusuf.movieapp.databinding.FragmentSearchScreenBinding
import com.yusuf.movieapp.model.SearchMovieResult
import com.yusuf.movieapp.services.SearchMovieGetService
import com.yusuf.movieapp.view.adapters.SearchViewCustomAdapter
import com.yusuf.movieapp.view.adapters.SearchViewCustomAdapterType
import com.yusuf.movieapp.viewmodel.SearchMovieApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SearchScreenFragment : Fragment() {
    private lateinit var binding: FragmentSearchScreenBinding
    private lateinit var searchSearchView: SearchView
    private lateinit var searchRecyclerView: RecyclerView
    lateinit var searchMovieGetService: SearchMovieGetService
    lateinit var get: MutableList<SearchMovieResult>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentSearchScreenBinding.inflate(inflater, container, false)
        searchSearchView = binding.searchSearchView
        searchRecyclerView = binding.searchRecyclerView
        searchMovieGetService =
            SearchMovieApiClient.getClient().create(SearchMovieGetService::class.java)

        val searchViewDataset = ArrayList<SearchViewCustomAdapterType>()
        val searchViewAdapter = SearchViewCustomAdapter(searchViewDataset)
        searchRecyclerView.adapter = searchViewAdapter

        searchSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                searchViewDataset.clear()
                searchViewAdapter.notifyDataSetChanged()
                val get = searchMovieGetService.get(newText)
                get.enqueue(object : Callback<SearchMovieResult> {
                    override fun onFailure(call: Call<SearchMovieResult>, t: Throwable) {
                    }

                    override fun onResponse(
                        call: Call<SearchMovieResult>,
                        searchViewresponse: Response<SearchMovieResult>
                    ) {
                        if (searchViewresponse.isSuccessful) {
                            if (searchViewresponse.body()?.searchResults?.isNotEmpty() == true) {
                                searchViewresponse.body()?.searchResults?.forEach { x ->
                                    searchViewDataset.add(
                                        SearchViewCustomAdapterType(
                                            movieId = x.movieId,
                                            searchMovieTitle = x.movieTitle,
                                            searchMovieImageUrl = x.posterPath,
                                            movieStarRate = x.voteAverage.toString()
                                                .substring(0, 3),
                                            movieReleaseDate = x.releaseDate.take(4)
                                        )
                                    )
                                    searchViewAdapter.notifyItemInserted(searchViewDataset.size)
                                }
                            }
                        }
                    }
                })
                return false
            }
        })

        return binding.root
    }
}




