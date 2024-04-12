package com.example.criminalintent.Data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity
data class Crime(
    //The crimeID serves as a unique identifier for each crime in the list view
    @PrimaryKey
    var crimeID: String,
    var title: CharSequence?,
    var date: String,
    var isSolved: Boolean,
    var requiresPolice : Boolean
)