package com.yusuf.movieapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
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


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        detailTextView = binding.detailTextView
        detailImageView = binding.detailImageView
        detailMovieTitle = binding.detailMovieTitle
        detailReleaseDate = binding.detailReleaseDate
        detailMovieStarPoint = binding.detailMovieStarPoint
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
                        detailMovieStarPoint.text =
                            detailDtoResultResponse.body()?.detailVoteAverage.toString()
                                .substring(0, 3)
                        Glide.with(detailImageView)
                            .load("https://image.tmdb.org/t/p/w500" + detailDtoResultResponse.body()?.posterPath)
                            .placeholder(com.bumptech.glide.R.drawable.abc_spinner_mtrl_am_alpha)
                            .into(detailImageView)



                    }
                }
            })
        }
        return binding.root
    }


}