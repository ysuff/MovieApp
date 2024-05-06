package com.yusuf.movieapp.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.yusuf.movieapp.data.Firebase.DatabaseFirebase
import com.yusuf.movieapp.data.MovieEntity
import com.yusuf.movieapp.data.MovieViewModel
import com.yusuf.movieapp.databinding.FragmentDetailBinding
import com.yusuf.movieapp.model.DetailDtoResult
import com.yusuf.movieapp.services.DetailService
import com.yusuf.movieapp.viewmodel.SearchMovieApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    lateinit var detailService: DetailService
    private lateinit var detailTextView: TextView
    private lateinit var detailMovieTitle: TextView
    private lateinit var detailMovieStarPoint: TextView
    private lateinit var detailReleaseDate: TextView
    private lateinit var detailImageView: ImageView
    private lateinit var detailGoBackSearchButton: Button
    private lateinit var detailAddFavoriteListButton: Button
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var detailDeleteButton: Button
    private lateinit var detailAddWatchListButton: Button
    private lateinit var detailRemoveFromWatchListButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        FirebaseApp.initializeApp(requireContext())
        binding = FragmentDetailBinding.inflate(inflater, container, false)



        detailTextView = binding.detailTextView
        detailImageView = binding.detailImageView
        detailMovieTitle = binding.detailMovieTitle
        detailReleaseDate = binding.detailReleaseDate
        detailMovieStarPoint = binding.detailMovieStarPoint
        detailGoBackSearchButton = binding.detailGoBackSearchButton
        detailDeleteButton = binding.detailDeleteButton
        detailRemoveFromWatchListButton = binding.detailRemoveFromWatchListButton
        detailAddFavoriteListButton = binding.detailAddFavoriteListButton
        detailAddWatchListButton = binding.detailAddWatchListButton




        movieViewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
        detailGoBackSearchButton.setOnClickListener {
            findNavController().popBackStack()
        }


        detailService = SearchMovieApiClient.getClient().create(DetailService::class.java)
        val get = getArguments()?.getInt("movieId")?.let { detailService.get(it) }
        if (get != null) {
            get.enqueue(object : Callback<DetailDtoResult> {
                override fun onFailure(call: Call<DetailDtoResult>, t: Throwable) {
                }

                override fun onResponse(
                    call: Call<DetailDtoResult>,
                    detailDtoResultResponse: Response<DetailDtoResult>
                ) {
                    if (detailDtoResultResponse.isSuccessful) {

                        detailTextView.text = detailDtoResultResponse.body()?.detailOverView
                        detailMovieTitle.text = detailDtoResultResponse.body()?.detailTitle
                        detailReleaseDate.text = detailDtoResultResponse.body()?.detailReleaseDate
                        detailMovieStarPoint.text =detailDtoResultResponse.body()?.detailVoteAverage.toString().substring(0, 3)
                        Glide.with(detailImageView)
                            .load("https://image.tmdb.org/t/p/w500" + detailDtoResultResponse.body()?.posterPath)
                            .placeholder(R.drawable.abc_spinner_mtrl_am_alpha)
                            .into(detailImageView)

                        val movieId = getArguments()?.getInt("movieId")
                        val movieTitle = detailDtoResultResponse.body()?.detailTitle.toString()
                        val moviePhoto = detailDtoResultResponse.body()?.posterPath.toString()
                        val movieReleaseDate= detailDtoResultResponse.body()?.detailReleaseDate?.take(4)
                        val movieStarRate=detailDtoResultResponse.body()?.detailVoteAverage
                        if (movieId != null) {
                            if (movieStarRate != null) {
                                if (movieReleaseDate != null) {
                                    checkMovie(movieId, movieTitle, moviePhoto,movieReleaseDate,movieStarRate)
                                }
                            }
                            if (movieReleaseDate != null) {
                                if (movieStarRate != null) {
                                    toggleWatchListButton(movieTitle, movieId.toString(), moviePhoto,movieReleaseDate,movieStarRate)
                                }
                            }

                        }


                    }

                }

            })

        }

        return binding.root
    }


    private fun checkMovie(
        movieId: Int, movieTitle: String, moviePhoto: String,movieReleaseDate: String,movieStarRate:Double) {
        movieViewModel.getMovieById(movieId).observe(viewLifecycleOwner) { existingMovie ->
            if (existingMovie == null) {
                detailAddFavoriteListButton.visibility = View.VISIBLE
                detailDeleteButton.visibility = View.INVISIBLE
            } else {
                detailAddFavoriteListButton.visibility = View.INVISIBLE
                detailDeleteButton.visibility = View.VISIBLE
            }

            detailAddFavoriteListButton.setOnClickListener {
                insertDataToDatabase(movieId, movieTitle, moviePhoto, movieReleaseDate, movieStarRate)
                Toast.makeText(
                    requireContext(),
                    "Successfully added to favorites",
                    Toast.LENGTH_LONG
                ).show()
            }

            detailDeleteButton.setOnClickListener {
                deleteMovie(movieId)
                Toast.makeText(
                    requireContext(),
                    "Successfully removed from favorites",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }


    private fun insertDataToDatabase(movieIdDb: Int, movieTitle: String, moviePhoto: String, movieReleaseDate: String, movieStarRate: Double) {
        val movieDetail = MovieEntity(movieIdDb, movieTitle, moviePhoto, movieReleaseDate, movieStarRate)
        movieViewModel.addMovie(movieDetail)
    }

    private fun deleteMovie(movieId: Int) {
        val movieToDelete = MovieEntity(movieId, "", "","",0.1)
        movieViewModel.deleteMovie(movieToDelete)
    }


    private fun toggleWatchListButton(movieTitle: String, movieId: String, moviePhoto: String,movieReleaseDate: String,movieStarRate: Double) {
        val fireBaseDataBase = FirebaseDatabase.getInstance().getReference("Movies")
        val query = fireBaseDataBase.orderByChild("movieTitle").equalTo(movieTitle)


        query.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    detailRemoveFromWatchListButton.visibility = View.VISIBLE
                    detailAddWatchListButton.visibility = View.GONE
                } else {
                    detailAddWatchListButton.visibility = View.VISIBLE
                    detailRemoveFromWatchListButton.visibility = View.GONE
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.e("Firebase", "Error: ${databaseError.message}")
            }
        })

        detailAddWatchListButton.setOnClickListener {
            val firebaseMovieTitle = movieTitle
            val firebaseMovieImage = moviePhoto
            val firebaseMovieRelaseDate=movieReleaseDate
            val firebaseMovieStarRate=movieStarRate

            val movie = DatabaseFirebase(movieId, firebaseMovieTitle, firebaseMovieImage,firebaseMovieRelaseDate,firebaseMovieStarRate)
            fireBaseDataBase.child(firebaseMovieTitle).setValue(movie)
                .addOnSuccessListener {
                    Toast.makeText(
                        requireContext(),
                        "Added to watch list successfully",
                        Toast.LENGTH_SHORT
                    ).show()
                }.addOnFailureListener { e ->
                    Toast.makeText(requireContext(), "Error: ${e.message}", Toast.LENGTH_SHORT)
                        .show()
                }

        }

        detailRemoveFromWatchListButton.setOnClickListener {
            val firebaseMovieTitle = movieTitle
            fireBaseDataBase.child(firebaseMovieTitle).removeValue()
                .addOnSuccessListener {
                    Toast.makeText(
                        requireContext(),
                        "Removed from watch list successfully",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                .addOnFailureListener { e ->
                    Toast.makeText(
                        requireContext(),
                        "Failed to remove from watch list: ${e.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }

        }
    }
}






