package com.example.criminalintent.ViewModel

import androidx.lifecycle.ViewModel
import com.example.criminalintent.Data.Crime
import java.util.UUID

class CrimeListViewModel : ViewModel() {
    var crimeObjects: MutableList<Crime>

    init {
        crimeObjects = mutableListOf<Crime>(
            Crime(UUID.randomUUID(), "Sink issue", "20-11-2024", false),
            Crime(UUID.randomUUID(), "Printer issue", "20-11-2024", true),
            Crime(UUID.randomUUID(), "Printer issue", "20-11-2024", true),
            Crime(UUID.randomUUID(), "Printer issue", "20-11-2024", true),
            Crime(UUID.randomUUID(), "Printer issue", "20-11-2024", true),
            Crime(UUID.randomUUID(), "Printer issue", "20-11-2024", true),
            Crime(UUID.randomUUID(), "Printer issue", "20-11-2024", true),
            Crime(UUID.randomUUID(), "Printer issue", "20-11-2024", true),
            Crime(UUID.randomUUID(), "Printer issue", "20-11-2024", true),
            Crime(UUID.randomUUID(), "Printer issue", "20-11-2024", true),
            Crime(UUID.randomUUID(), "Printer issue", "20-11-2024", true),
            Crime(UUID.randomUUID(), "Printer issue", "20-11-2024", true),
            Crime(UUID.randomUUID(), "Printer issue", "20-11-2024", true),
            Crime(UUID.randomUUID(), "Printer issue", "20-11-2024", true),
            Crime(UUID.randomUUID(), "Printer issue", "20-11-2024", true)
        )
    }

    fun getCrimeObject(): MutableList<Crime> {
        return crimeObjects
    }
}