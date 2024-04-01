package com.example.criminalintent.Adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.criminalintent.Data.Crime
import com.example.criminalintent.databinding.CrimeItemLayoutBinding


/**
 * ViewHolder class for displaying individual items in a RecyclerView.
 *
 * This ViewHolder holds references to the views in the item layout and binds data to them.
 *
 * @param binding The ViewBinding object containing references to the views in the item layout.
 */

class CrimeViewHolder (private val itemLayoutBinding: CrimeItemLayoutBinding) :RecyclerView.ViewHolder(itemLayoutBinding.root) {

    /**
     * Binds the given crime data to the views in the ViewHolder.
     *
     * @param crime The Crime object containing data to be displayed.
     */

    fun bindDataToTheView(crime :Crime){
        itemLayoutBinding.textViewCrimeId.text = crime.crimeID.toString()
        itemLayoutBinding.textViewDate.text = crime.date

    }

}