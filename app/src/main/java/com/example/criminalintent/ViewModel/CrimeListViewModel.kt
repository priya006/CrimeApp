package com.example.criminalintent.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.criminalintent.DataBase.Crime
import com.example.criminalintent.Repository.CrimeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.Date
import java.util.UUID

class CrimeListViewModel : ViewModel() {
    private val crimeRepository = CrimeRepository.get()

    private val _crimes: MutableStateFlow<List<Crime>> = MutableStateFlow(emptyList())
    val crimes: StateFlow<List<Crime>>
        get() = _crimes.asStateFlow()

    init {

        viewModelScope.launch {
            repeat(20) {
                val crime = Crime(UUID.randomUUID(), "Example Crime $it", Date(), isSolved = false)
                crimeRepository.insertCrime(crime)
            }
        }

        viewModelScope.launch {
            crimeRepository.getCrimes().collect {
                _crimes.value = it
            }
        }

//        viewModelScope.launch {
//            val id = UUID.randomUUID()
//             crimeRepository.getCrime(id).collect{ crime ->
//                _crimes.value = crime
//            }
//            // Do something with the fetched crime, such as updating UI
//        }

    }


}

