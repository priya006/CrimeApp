package com.example.criminalintent.Adapter

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.criminalintent.DataBase.Crime
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

    fun bindDataToTheView(crime : Crime){
        itemLayoutBinding.crimeSolved.text = crime.id.toString()
        itemLayoutBinding.textViewDate.text = crime.date
        itemLayoutBinding?.root?.setOnClickListener {

            Toast.makeText(itemLayoutBinding.root.context,"${crime.date}",
                Toast.LENGTH_LONG).show()
        }
        itemLayoutBinding.imageCuff.visibility = if(crime.isSolved)  View.VISIBLE else View.GONE
    }
}