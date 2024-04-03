package com.example.criminalintent.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.criminalintent.Adapter.CrimeAdapter
import com.example.criminalintent.Data.Crime
import com.example.criminalintent.ViewModel.CrimeListViewModel
import com.example.criminalintent.databinding.CriminalListBinding
import java.time.Duration
import java.util.UUID

class CrimeListFragment : Fragment() {

    private val crimeListViewModel: CrimeListViewModel by viewModels()
    private var _criminalListBinding: CriminalListBinding? = null
    private val criminalListBinding get() = _criminalListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        viewGroup: ViewGroup?,
        saveInstanceState: Bundle?
    ): View? {
        _criminalListBinding = CriminalListBinding.inflate(inflater, viewGroup, false)
        // Get a reference to the RecyclerView
        val recyclerView = criminalListBinding?.recyclerView
        // Set up the RecyclerView adapter
        val crimeAdapter = CrimeAdapter(crimeList = crimeListViewModel.getCrimeObject())
        recyclerView?.adapter = crimeAdapter
        // Set layout manager for the RecyclerView
        recyclerView?.layoutManager = LinearLayoutManager(requireContext())
        return criminalListBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //initialize the layout manager
        var layoutManager = LinearLayoutManager(context)
        _criminalListBinding?.recyclerView?.layoutManager = layoutManager


    }

    //Release the resources
    override fun onDestroyView() {
        super.onDestroyView()
        _criminalListBinding = null
    }
}