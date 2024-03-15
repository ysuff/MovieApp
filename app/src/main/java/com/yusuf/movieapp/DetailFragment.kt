package com.yusuf.movieapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yusuf.movieapp.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
        private lateinit var binding: FragmentDetailBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       binding= FragmentDetailBinding.inflate(inflater,container,false)
        return binding.root
    }


}