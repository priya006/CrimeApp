package com.example.criminalintent.ViewModel

import androidx.lifecycle.ViewModel
import com.example.criminalintent.Data.Crime
import java.util.UUID

class CrimeListViewModel : ViewModel() {
    var crimeObjects: MutableList<Crime>

    init {
        crimeObjects = mutableListOf<Crime>(
            Crime(UUID.randomUUID(), "Sink issue", "20-11-2024", false, false),
            Crime(UUID.randomUUID(), "Printer issue", "20-11-2024", true , false),
            Crime(UUID.randomUUID(), "Printer issue", "20-11-2024", true , false),
            Crime(UUID.randomUUID(), "Printer issue", "20-11-2024", true , false),
            Crime(UUID.randomUUID(), "Printer issue", "20-11-2024", true , false),
            Crime(UUID.randomUUID(), "Printer issue", "20-11-2024", true , false),
            Crime(UUID.randomUUID(), "Printer issue", "20-11-2024", true , false),
            Crime(UUID.randomUUID(), "Printer issue", "20-11-2024", true , false),
            Crime(UUID.randomUUID(), "Printer issue", "20-11-2024", true , false),
            Crime(UUID.randomUUID(), "Printer issue", "20-11-2024", true , false),
        )
    }

    fun getCrimeObject(): MutableList<Crime> {
        return crimeObjects
    }
}