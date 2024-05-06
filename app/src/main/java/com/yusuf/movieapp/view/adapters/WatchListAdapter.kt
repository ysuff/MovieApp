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
import com.yusuf.movieapp.data.Firebase.DatabaseFirebase
import com.yusuf.movieapp.view.WatchlistFragmentDirections

class WatchListAdapter(private val watchListDataSet: ArrayList<DatabaseFirebase>) :
    RecyclerView.Adapter<WatchListAdapter.WatchListViewHolder>() {
    class WatchListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val watchListTextView: TextView
        val watchListImageView: ImageView


        init {
            watchListTextView = itemView.findViewById(R.id.watchListItemTextView)
            watchListImageView = itemView.findViewById(R.id.watchListItemImageView)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WatchListViewHolder {
        return WatchListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.watch_list_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return watchListDataSet.size
    }

    override fun onBindViewHolder(holder: WatchListViewHolder, position: Int) {
        val currentItem = watchListDataSet[position]
        holder.watchListTextView.text = currentItem.movieTitle


        val movieImageURL = currentItem.movieImageView
        Glide.with(holder.watchListImageView)
            .load("https://image.tmdb.org/t/p/w500" + watchListDataSet[position].movieImageView)

            .placeholder(com.bumptech.glide.R.drawable.abc_spinner_mtrl_am_alpha)
            .into(holder.watchListImageView)


        holder.itemView.setOnClickListener {
            val bundle = Bundle()
            watchListDataSet[position].movieId?.let { movieId ->
                bundle.putInt("movieId", movieId.toInt())
            }

            val watchListAction =
                WatchlistFragmentDirections.actionWatchlistFragmentToDetailFragment()
            Navigation.findNavController(it).navigate(watchListAction.actionId, bundle)
        }
    }


}
