package com.yusuf.movieapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.yusuf.movieapp.databinding.FragmentSerchScreenBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SerchScreenFragment : Fragment() {
    private lateinit var binding: FragmentSerchScreenBinding
    private lateinit var searchSearchView: SearchView
    private lateinit var searchRecyclerView: RecyclerView
    lateinit var getService: GetService
    lateinit var get: MutableList<Resault>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSerchScreenBinding.inflate(inflater, container, false)
        searchSearchView = binding.searchSearchView
        searchRecyclerView = binding.searchRecyclerView
        getService = ApiClient.getClient().create(GetService::class.java)

        val dataSet = ArrayList<CustomAdapterType>()


        val customAdapter = CustomAdapter(dataSet)
        searchRecyclerView.adapter = customAdapter

        searchSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                dataSet.clear()
                customAdapter.notifyDataSetChanged()
                val get = getService.get(query)
                get.enqueue(object : Callback<Resault> {
                    override fun onFailure(call: Call<Resault>, t: Throwable) {
                        println(t.message)
                    }

                    override fun onResponse(call: Call<Resault>, response: Response<Resault>) {
                        if (response.isSuccessful) {
                            if (response.body()?.results?.size!=0) {
                                response.body()?.results?.forEach { x ->
                                    run {
                                        dataSet.add(
                                            CustomAdapterType(
                                                title = x.originalTitle,
                                                imageUrl = x.posterPath
                                            )
                                        )

                                        customAdapter.notifyItemInserted(dataSet.size - 1)
                                    }
                                }

                            }else{dataSet.add(CustomAdapterType(title = "Not Found!!"))
                                customAdapter.notifyItemInserted(0)


                            }



                        }
                        println(response)
                    }

                })
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })

        return binding.root

    }


}