package com.yusuf.movieapp.view.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yusuf.movieapp.R
import com.yusuf.movieapp.view.SearchScreenFragmentDirections


data class SearchViewCustomAdapterType(
    val searchMovieTitle: String = "",
    val searchMovieImageUrl: String? = "",
    val movieId: Int = 0,
    val movieStarRate: String ="",
    val movieReleaseDate:String=""
)

class SearchViewCustomAdapter(private val searchViewDataSet: ArrayList<SearchViewCustomAdapterType>) :
    RecyclerView.Adapter<SearchViewCustomAdapter.SearchViewHolder>() {
    class SearchViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val searchMovieTextView: TextView
        val searchMovieImageView: ImageView
        val searchMovieStarRate: TextView
        val searchMovieReleaseDate: TextView


        init {
            searchMovieTextView = view.findViewById(R.id.itemText)
            searchMovieImageView = view.findViewById(R.id.itemImageView)
            searchMovieStarRate = view.findViewById(R.id.searchStarRate)
            searchMovieReleaseDate = view.findViewById(R.id.searchReleaseDate)

        }
    }


    override fun onCreateViewHolder(searchViewGroup: ViewGroup, viewType: Int): SearchViewHolder {
        val view = LayoutInflater.from(searchViewGroup.context)

            .inflate(R.layout.search_movie_item, searchViewGroup, false)

        return SearchViewHolder(view)
    }

    override fun onBindViewHolder(searchViewHolder: SearchViewHolder, position: Int) {


        searchViewHolder.searchMovieTextView.text = searchViewDataSet[position].searchMovieTitle
        searchViewHolder.searchMovieStarRate.text= searchViewDataSet[position].movieStarRate
        searchViewHolder.searchMovieReleaseDate.text=searchViewDataSet[position].movieReleaseDate
        Glide.with(searchViewHolder.searchMovieImageView)
            .load("https://image.tmdb.org/t/p/w500" + searchViewDataSet[position].searchMovieImageUrl)

            .placeholder(com.bumptech.glide.R.drawable.abc_list_pressed_holo_dark)
            .into(searchViewHolder.searchMovieImageView)

        searchViewHolder.itemView.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("movieId", searchViewDataSet[position].movieId)

            val searchViewAction =
                SearchScreenFragmentDirections.actionSearchScreenFragmentToDetailFragment()
            Navigation.findNavController(it).navigate(searchViewAction.actionId, bundle)
        }



    }


    override fun getItemCount() = searchViewDataSet.size

}

