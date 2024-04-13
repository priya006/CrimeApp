package com.example.criminalintent.ViewModel

import androidx.lifecycle.ViewModel
import com.example.criminalintent.DataBase.Crime
import com.example.criminalintent.Repository.CrimeRepository

class CrimeListViewModel(private val crimeRepository: CrimeRepository) : ViewModel() {
 // private  var crimeObjects: MutableList<Crime> = mutableListOf()

//    init {
//        //Based on the data passed to requirespolice we determine which layout to render
//
//            crimeObjects.add(crimeRepository.getCrimes())
//
//        crimeObjects.add(5,
//            Crime("crime #$9", "Sink issue", "2023-02-15T15:30:00-08:00", false, true)
//        )
//        for (i in 6 until 20 ){
//            crimeObjects.add(i,
//                Crime("crime #$i", "Sink issue", "2024-02-15T15:30:00-08:00", false, false)
//            )
//        }
//    }

    suspend fun getCrimeObject():List<Crime> {
        return crimeRepository.getCrimes()
    }
}
