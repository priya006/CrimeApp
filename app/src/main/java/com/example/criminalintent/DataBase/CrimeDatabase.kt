package com.example.criminalintent.DataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.criminalintent.Data.Crime

@Database(entities = [Crime::class], version = 1)
abstract class CrimeDatabase : RoomDatabase() {
}