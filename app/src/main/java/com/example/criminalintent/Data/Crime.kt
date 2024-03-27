package com.example.criminalintent.Data

import java.util.Date
import java.util.UUID

data class Crime(
    //The crimeID serves as a unique identifier for each crime in the list view
    var crimeID: UUID,
    var title: CharSequence?,
    var date: Date,
    var isSolved: Boolean
)
