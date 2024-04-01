package com.example.criminalintent.Adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.criminalintent.Data.Crime
import com.example.criminalintent.databinding.CrimeItemLayoutBinding

class CrimeAdapter(private val itemLayoutBinding: CrimeItemLayoutBinding, private val crimeObject: List<Crime>) : RecyclerView.Adapter<CrimeViewHolder>() {

    //Returning an instance of CrimeViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrimeViewHolder {
      return  CrimeViewHolder(itemLayoutBinding)
    }

    override fun onBindViewHolder(viewHolder: CrimeViewHolder, position: Int){
        //you'll use the CrimeViewHolder to bind data to the views in each item of the RecyclerView.
        val crime = crimeObject[position]
        viewHolder.bindDataToTheView(crime)
    }

    override fun getItemCount():Int{
        return crimeObject.size
    }
}