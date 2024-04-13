package com.example.criminalintent.Repository

import android.content.Context


class CrimeRepository private constructor(private val context: Context) {

    companion object{
        private var crimeRepository : CrimeRepository? = null

    fun getInstance(context: Context):CrimeRepository{
        if(crimeRepository == null) {
            crimeRepository = CrimeRepository(context)
        }
        return crimeRepository ?: throw IllegalStateException("Creation of CrimeRepository object failed ")
    }

    }
    //TODO Accessing Dao which has query
    }
