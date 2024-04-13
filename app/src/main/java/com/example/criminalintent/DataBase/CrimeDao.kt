package com.example.criminalintent.DataBase

import androidx.room.Dao
import androidx.room.Query
import java.util.UUID

@Dao
interface CrimeDao {

    @Query("SELECT * FROM crime")
    suspend fun getCrimes() : List<Crime>

//    @Query("Select * FROM crime WHERE id = :id")
//     fun getCrime(id: Int) :Crime
}