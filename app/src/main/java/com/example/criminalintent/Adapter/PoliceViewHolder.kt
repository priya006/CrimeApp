package com.example.criminalintent.Adapter

import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.criminalintent.Data.Crime
import com.example.criminalintent.databinding.PoliceLayoutBinding

class PoliceViewHolder( private val policeLayoutBinding: PoliceLayoutBinding ) : RecyclerView.ViewHolder(policeLayoutBinding.root) {


    fun bindToPoliceViewHolder(crime:Crime){
        policeLayoutBinding.buttonContactPolice.text = crime.title
        policeLayoutBinding.buttonContactPolice.setOnClickListener {
            Toast.makeText(policeLayoutBinding.buttonContactPolice.context, "button u clicked",Toast.LENGTH_LONG).show()
        }
    }

}