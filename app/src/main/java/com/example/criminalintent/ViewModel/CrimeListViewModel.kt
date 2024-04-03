package com.example.criminalintent.ViewModel

import androidx.lifecycle.ViewModel
import com.example.criminalintent.Data.Crime

class CrimeListViewModel : ViewModel() {
    var crimeObjects: MutableList<Crime> = mutableListOf()

    init {
        //Based on the data passed to requirespolice we determine which layout to render
        for (i in 0 until 25 ){
            crimeObjects.add(i,Crime("crime #$i", "Sink issue", "2024-02-15T15:30:00-08:00", false, false))
        }
        crimeObjects.add(9,Crime("crime #$9", "Sink issue", "2023-02-15T15:30:00-08:00", false, true))
    }

    fun getCrimeObject(): MutableList<Crime> {
        return crimeObjects
    }
}
