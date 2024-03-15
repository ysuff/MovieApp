package com.yusuf.movieapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yusuf.movieapp.databinding.FragmentFavoritesBinding
import com.yusuf.movieapp.databinding.FragmentSerchScreenBinding


class SerchScreenFragment : Fragment() {
    private lateinit var binding: FragmentSerchScreenBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentSerchScreenBinding.inflate(inflater,container,false)
        return binding.root
    }


}