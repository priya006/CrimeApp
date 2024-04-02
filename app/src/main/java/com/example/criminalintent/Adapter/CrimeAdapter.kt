package com.example.criminalintent.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.criminalintent.Data.Crime
import com.example.criminalintent.databinding.CrimeItemLayoutBinding
import com.example.criminalintent.databinding.PoliceLayoutBinding

class CrimeAdapter(private val crimeList: List<Crime>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val VIEW_TYPE_WITH_POLICE = 1
    private val VIEW_TYPE_WITH_OUT_POLICE = 0

    //Returning an instance of CrimeViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {


        return when (viewType) {
            VIEW_TYPE_WITH_POLICE -> {
                val inflater = LayoutInflater.from(parent.context)
                val policeLayoutBinding = PoliceLayoutBinding.inflate(inflater, parent, false)
                ButtonViewHolder(policeLayoutBinding)
            }

            VIEW_TYPE_WITH_OUT_POLICE -> {
                val inflater = LayoutInflater.from(parent.context)
                val itemLayoutBinding = CrimeItemLayoutBinding.inflate(inflater, parent, false)
                CrimeViewHolder(itemLayoutBinding)
            }

            else -> throw IllegalArgumentException("Invalid view type")

        }
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the [ViewHolder.itemView] to reflect the item at the given
     * position.
     *
     *
     * Note that unlike [android.widget.ListView], RecyclerView will not call this method
     * again if the position of the item changes in the data set unless the item itself is
     * invalidated or the new position cannot be determined. For this reason, you should only
     * use the `position` parameter while acquiring the related data item inside
     * this method and should not keep a copy of it. If you need the position of an item later
     * on (e.g. in a click listener), use [ViewHolder.getAdapterPosition] which will
     * have the updated adapter position.
     *
     * Override [.onBindViewHolder] instead if Adapter can
     * handle efficient partial bind.
     *
     * @param recyclerViewHolder The ViewHolder which should be updated to represent the contents of the
     * item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    override fun onBindViewHolder(recyclerViewHolder: RecyclerView.ViewHolder, position: Int) {
        //you'll use the CrimeViewHolder to bind data to the views in each item of the RecyclerView.
        val crime = crimeList[position]
        if(recyclerViewHolder is CrimeViewHolder){
            val crimeViewHolder = recyclerViewHolder
            crimeViewHolder.bindDataToTheView(crime)
        }

        if(recyclerViewHolder is ButtonViewHolder){
            val policeViewHolder = recyclerViewHolder
            policeViewHolder.bindToPoliceViewHolder(crime)
        }
    }


    override fun getItemCount(): Int {
        return crimeList.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (crimeList[position].requiresPolice) {
            VIEW_TYPE_WITH_POLICE
        } else {
            VIEW_TYPE_WITH_OUT_POLICE
        }
    }
}