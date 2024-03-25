package com.yusuf.movieapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.yusuf.movieapp.databinding.FragmentWatchlistBinding
import com.yusuf.movieapp.databinding.FragmentYourBinding


class YourFragment : Fragment() {
  private lateinit var binding: FragmentYourBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=FragmentYourBinding.inflate(inflater,container,false)
        return binding.root

    }

}



