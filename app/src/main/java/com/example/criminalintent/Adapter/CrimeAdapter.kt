package com.example.criminalintent.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.criminalintent.Data.Crime
import com.example.criminalintent.databinding.CrimeItemLayoutBinding

class CrimeAdapter( private val crimeList: List<Crime>) : RecyclerView.Adapter<CrimeViewHolder>() {

    //Returning an instance of CrimeViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrimeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemLayoutBinding = CrimeItemLayoutBinding.inflate(inflater, parent, false)
      return  CrimeViewHolder(itemLayoutBinding)
    }

    override fun onBindViewHolder(viewHolder: CrimeViewHolder, position: Int){
        //you'll use the CrimeViewHolder to bind data to the views in each item of the RecyclerView.
        val crime = crimeList[position]
        viewHolder.bindDataToTheView(crime)
    }

    override fun getItemCount():Int{
        return crimeList.size
    }
}