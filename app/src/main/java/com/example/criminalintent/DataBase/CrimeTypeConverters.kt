package com.example.criminalintent.DataBase

import androidx.room.TypeConverter
import java.util.Date

class CrimeTypeConverters {

    @TypeConverter
    fun fromDate(date: Date) :Long{
        return date.time
    }

    @TypeConverter
    fun toDate(timestamp: Long?): Date? {
        return timestamp?.let { Date(it) } // Convert Long to Date
    }
}