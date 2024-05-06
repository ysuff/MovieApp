package com.yusuf.movieapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.yusuf.movieapp.data.Firebase.DatabaseFirebase
import com.yusuf.movieapp.databinding.FragmentWatchlistBinding
import com.yusuf.movieapp.view.adapters.WatchListAdapter


class WatchlistFragment : Fragment() {
    private lateinit var binding: FragmentWatchlistBinding
    private lateinit var databaseFirebase: DatabaseReference
    private lateinit var watchListRecyclerView: RecyclerView
    private lateinit var watchListViewAdapter: WatchListAdapter
    private lateinit var contactList: ArrayList<DatabaseFirebase>
    private lateinit var firebaseRef: DatabaseReference


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWatchlistBinding.inflate(inflater, container, false)
        watchListRecyclerView = binding.watchListRecyclerView
        firebaseRef = FirebaseDatabase.getInstance().getReference("Movies")
        contactList = arrayListOf()

        fetchData()
        watchListRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this.context)
        }

        return binding.root
    }

    private fun fetchData() {
        firebaseRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (contactSnap in snapshot.children) {
                        val databaseFirebase = contactSnap.getValue(DatabaseFirebase::class.java)
                        if (databaseFirebase != null) {
                            contactList.add(databaseFirebase)
                        }
                    }
                    val adapter = WatchListAdapter(contactList)
                    watchListRecyclerView.adapter = adapter
                }
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })
    }
}


