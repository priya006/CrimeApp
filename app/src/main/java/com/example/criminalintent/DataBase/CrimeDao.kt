package com.example.criminalintent.DataBase

import androidx.room.Dao
import androidx.room.Query
import java.util.UUID

@Dao
interface CrimeDao {

    @Query("SELECT * FROM crime")
    suspend fun getCrimes() {

    }

    @Query("Select * FROM crime WHERE crimeID = crimeID")
    suspend fun getCrime(crimeID: String) {

    }
}