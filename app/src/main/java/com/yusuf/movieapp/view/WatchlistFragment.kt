package com.yusuf.movieapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yusuf.movieapp.databinding.FragmentWatchlistBinding


class WatchlistFragment : Fragment() {
    private lateinit var binding: FragmentWatchlistBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWatchlistBinding.inflate(inflater, container, false)
        return binding.root


    }
}