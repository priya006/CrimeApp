package com.example.criminalintent.ViewModel

import androidx.lifecycle.ViewModel
import com.example.criminalintent.Data.Crime

class CrimeListViewModel : ViewModel() {
  private  var crimeObjects: MutableList<Crime> = mutableListOf()

    init {
        //Based on the data passed to requirespolice we determine which layout to render
        for (i in 0 until 5 ){
            crimeObjects.add(i,Crime("crime #$i", "Sink issue", "2024-02-15T15:30:00-08:00", true, false))
        }
        crimeObjects.add(5,Crime("crime #$9", "Sink issue", "2023-02-15T15:30:00-08:00", false, true))
        for (i in 6 until 20 ){
            crimeObjects.add(i,Crime("crime #$i", "Sink issue", "2024-02-15T15:30:00-08:00", false, false))
        }
    }

    fun getCrimeObject(): MutableList<Crime> {
        return crimeObjects
    }
}
