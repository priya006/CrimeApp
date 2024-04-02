package com.example.criminalintent.ViewModel

import androidx.lifecycle.ViewModel
import com.example.criminalintent.Data.Crime

class CrimeListViewModel : ViewModel() {
    var crimeObjects: MutableList<Crime> = mutableListOf()

    init {
        //Based on the data passed to requirespolice we determine which layout to render
        for (i in 0 until 10 ){
            crimeObjects.add(i,Crime("crime #$i", "Sink issue", "20-11-2024", false, false))
        }
        crimeObjects.add(9,Crime("crime #$9", "Sink issue", "20-11-2024", false, true))
    }

    fun getCrimeObject(): MutableList<Crime> {
        return crimeObjects
    }
}
