package com.example.criminalintent.Repository

import android.content.Context
import androidx.room.Room
import com.example.criminalintent.DataBase.Crime
import com.example.criminalintent.DataBase.CrimeDatabase
import com.example.criminalintent.ViewModel.CrimeListViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import java.util.UUID

private const val DATABASE_NAME = "crime-database"

class CrimeRepository private constructor(private val context: Context) {

//    private val database: CrimeDatabase = Room
//        .databaseBuilder(
//            context.applicationContext,
//            CrimeDatabase::class.java,
//            DATABASE_NAME
//        )
//        .fallbackToDestructiveMigration()
//        .createFromAsset(DATABASE_NAME)
//        .build()

    private var database: CrimeDatabase? = null

    fun getDatabase(context: Context): CrimeDatabase {
        if (database == null) {
            synchronized(CrimeDatabase::class.java) {
                if (database == null) {
                    database = Room.databaseBuilder(
                        context.applicationContext,
                        CrimeDatabase::class.java,
                        "crime_database"
                    ).build()
                }
            }
        }
        return database!!
    }

    suspend fun insertCrime(crime: Crime) {
       return getDatabase(context).crimeDao().insertCrime(crime)
    }
    suspend fun getCrimes():Flow<List<Crime>> {
        return withContext(Dispatchers.IO)
        {
            getDatabase(context).crimeDao().getCrimes()
        }
    }

    suspend fun getCrime(id: UUID): Crime {
        return withContext(Dispatchers.IO){
            getDatabase(context).crimeDao().getCrime(id)
        }
    }



    companion object {
        private var INSTANCE: CrimeRepository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = CrimeRepository(context)
            }
        }

        fun get(): CrimeRepository {
            return INSTANCE
                ?: throw IllegalStateException("CrimeRepository must be initialized")
        }
    }
}
