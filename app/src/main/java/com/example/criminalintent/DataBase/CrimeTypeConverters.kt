package com.example.criminalintent.DataBase

import androidx.room.TypeConverter
import java.util.Date


/*
Room cannot store Date. So A type converter tells
Room how to convert a "Date Object" to the format it needs to store in the database
 */
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