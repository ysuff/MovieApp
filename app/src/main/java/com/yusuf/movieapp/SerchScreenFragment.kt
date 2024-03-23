package com.yusuf.movieapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.SearchView
import android.widget.TextView
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.yusuf.movieapp.databinding.FragmentFavoritesBinding
import com.yusuf.movieapp.databinding.FragmentSerchScreenBinding
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import android.util.JsonReader as JsonReader


class SerchScreenFragment : Fragment() {
    private lateinit var binding: FragmentSerchScreenBinding
    private lateinit var textView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentSerchScreenBinding.inflate(inflater,container,false)
        return binding.root


    }

}