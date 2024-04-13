package com.example.criminalintent.Repository

import android.content.Context
import androidx.room.Room
import com.example.criminalintent.DataBase.Crime
import com.example.criminalintent.DataBase.CrimeDatabase


class CrimeRepository private constructor( context: Context) {

    companion object{
        private var crimeRepository : CrimeRepository? = null



    fun getInstance(context: Context){
        if(crimeRepository == null) {
            crimeRepository = CrimeRepository(context)
        }
    }

    fun get():    CrimeRepository{
        return crimeRepository ?: throw IllegalStateException("Creation of CrimeRepository object failed ")
    }

    }
    private val crimeDatabase :CrimeDatabase = Room.databaseBuilder(context.applicationContext,CrimeDatabase::class.java,"crime-database")
        .createFromAsset("crime-database")
        .fallbackToDestructiveMigration()
        .build()

    suspend fun getCrimes():List<Crime>{
      return   crimeDatabase.crimeDao().getCrimes()
    }

//    suspend fun getCrime(id: Int):Crime{
//        return crimeDatabase.crimeDao().getCrime(id)
//    }

    }
