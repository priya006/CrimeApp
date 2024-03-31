package com.example.criminalintent.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.criminalintent.Data.Crime
import com.example.criminalintent.ViewModel.CrimeListViewModel
import com.example.criminalintent.databinding.CriminalListBinding
import java.util.UUID

class CrimeListFragment :Fragment() {

    private val crimeListViewModel : CrimeListViewModel by viewModels()
    private lateinit var recyclerView : RecyclerView
    private var _criminalListBinding:CriminalListBinding? = null
    private val criminalListBinding get() =  _criminalListBinding

    init {
        //populate data to Crime object
        for(i in 1..100){
           val crime =  Crime(
               crimeID = UUID.randomUUID(),
               title = "some String $i",
               date = "",
               isSolved = true
           )
        }
    }

    override fun onCreateView(inflater: LayoutInflater, viewGroup : ViewGroup?, saveInstanceState: Bundle?): View? {
        _criminalListBinding =  CriminalListBinding.inflate(inflater,viewGroup,false)
      return  criminalListBinding?.root

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