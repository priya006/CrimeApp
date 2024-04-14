package com.example.criminalintent.DataBase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import java.util.UUID@Dao
interface CrimeDao
{
@Insert(onConflict = OnConflictStrategy.REPLACE)
suspend fun insertCrime(crime: Crime)

    @Query("SELECT * FROM crime")
    fun getCrimes(): Flow<List<Crime>>

    @Query("SELECT * FROM crime WHERE id=(:id)")
    suspend fun getCrime(id: UUID): Flow<Int>
}

