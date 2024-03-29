package com.example.criminalintent.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.criminalintent.Data.Crime
import com.example.criminalintent.R
import com.example.criminalintent.ViewModel.CrimeListViewModel
import java.util.UUID

class CrimeListFragment :Fragment() {

    private val crimeListViewModel : CrimeListViewModel by viewModels()

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
        return inflater.inflate(R.layout.criminal_intent_layout,viewGroup,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Access the views
    }


    //TODO: layout for the list fragment
}