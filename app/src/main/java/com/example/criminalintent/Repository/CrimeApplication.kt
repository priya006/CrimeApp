package com.example.criminalintent.Repository

import android.app.Application
import com.example.criminalintent.DataBase.CrimeDatabase

class CrimeApplication :Application() {

    override fun onCreate() {
        super.onCreate()
        // Initialize Repository
        val crimeRepository = CrimeRepository.getInstance(this)
    }



}