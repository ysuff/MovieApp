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
import com.yusuf.movieapp.data.MovieEntity
import com.yusuf.movieapp.view.FavoriteFragmentsDirections


class FavoriteMovieAdapter(private val favoriteViewDataSet: ArrayList<MovieEntity>) :
    RecyclerView.Adapter<FavoriteMovieAdapter.FavoriteViewHolder>() {


    class FavoriteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val favoriTitle: TextView
        val favoriteMovieImageView: ImageView
        val searchMovieStarRate: TextView
        val searchMovieReleaseDate: TextView


        init {
            favoriTitle = itemView.findViewById(R.id.itemText)
            favoriteMovieImageView = itemView.findViewById(R.id.itemImageView)
            searchMovieStarRate = itemView.findViewById(R.id.searchStarRate)
            searchMovieReleaseDate = itemView.findViewById(R.id.searchReleaseDate)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        return FavoriteViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.search_movie_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return favoriteViewDataSet.size
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val currentItem = favoriteViewDataSet[position]
        holder.searchMovieStarRate.text = favoriteViewDataSet[position].movieStarRate.toString()
        holder.searchMovieReleaseDate.text = favoriteViewDataSet[position].movieReleaseDate
        holder.favoriTitle.text = currentItem.movieTitle
        Glide.with(holder.favoriteMovieImageView)
            .load("https://image.tmdb.org/t/p/w500" + favoriteViewDataSet[position].moviePhoto)

            .placeholder(com.bumptech.glide.R.drawable.abc_spinner_mtrl_am_alpha)
            .into(holder.favoriteMovieImageView)



        holder.itemView.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("movieId", favoriteViewDataSet[position].movieIdDb)

            val favoriteViewAction =
                FavoriteFragmentsDirections.actionFavoriteFragmentsToDetailFragment()
            Navigation.findNavController(it).navigate(favoriteViewAction.actionId, bundle)
        }

    }


}