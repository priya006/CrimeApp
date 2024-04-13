package com.example.criminalintent.Repository

import android.app.Application

class CrimeApplication :Application() {

    override fun onCreate() {
        super.onCreate()
        // invoke creation of CrimeRepository singleton object
        CrimeRepository.getInstance(this)
    }



}