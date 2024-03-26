package com.yusuf.movieapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.gson.annotations.SerializedName

data class CustomAdapterType(
    val title:String="",
    val imageUrl:String?=""


    )
class CustomAdapter(private val dataSet: ArrayList<CustomAdapterType>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        val imageView:ImageView
        init {
            textView = view.findViewById(R.id.itemText)
            imageView=view.findViewById(R.id.itemImageView)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)

            .inflate(R.layout.item, viewGroup, false)


        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.textView.text = dataSet[position].title
        Glide.with(viewHolder.imageView)
            .load("https://image.tmdb.org/t/p/w500" + dataSet[position].imageUrl).placeholder(com.bumptech.glide.R.drawable.abc_spinner_mtrl_am_alpha)
            .into(viewHolder.imageView);
    }

    override fun getItemCount() = dataSet.size

}