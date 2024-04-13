package com.example.criminalintent.Adapter

import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.criminalintent.DataBase.Crime
import com.example.criminalintent.databinding.PoliceLayoutBinding

class ButtonViewHolder(private val policeLayoutBinding: PoliceLayoutBinding ) : RecyclerView.ViewHolder(policeLayoutBinding.root) {


    fun bindToPoliceViewHolder(crime: Crime){
        policeLayoutBinding.buttonContactPolice.text = crime.title
        policeLayoutBinding.buttonContactPolice.setOnClickListener {
            Toast.makeText(policeLayoutBinding.buttonContactPolice.context, "This is Button Click coming from a different layout",Toast.LENGTH_LONG).show()
        }
    }

}