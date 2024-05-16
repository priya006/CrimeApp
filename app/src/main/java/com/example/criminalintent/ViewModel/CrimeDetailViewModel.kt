package com.example.criminalintent.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.criminalintent.DataBase.Crime
import com.example.criminalintent.Repository.CrimeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.UUID

class CrimeDetailViewModel(crimeId:UUID) : ViewModel() {
    private val crimeRepository = CrimeRepository.get()
    private val _crime : MutableStateFlow<Crime?> = MutableStateFlow(null)
    val crime: StateFlow<Crime?>
        get() = _crime.asStateFlow()

    init {
        viewModelScope.launch {
            _crime.value = crimeRepository.getCrime(crimeId)
        }
    }

    //Updating the oldCrime Object with the new value from the fragment
    fun updateCrime(onUpdate: (Crime) -> Crime) {
        _crime.update { oldCrime ->
            oldCrime?.let { onUpdate(it) }
        }
    }

    override fun onCleared(){
        super.onCleared()
            _crime.value.let {
                if (it != null) {
                    crimeRepository.updateCrime(it)
                }
        }
    }
}

class CrimeDetailViewModelFactory(
    private val crimeId:UUID
) :ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CrimeDetailViewModel(crimeId) as T
    }
}