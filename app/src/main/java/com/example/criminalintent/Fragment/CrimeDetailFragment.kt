package com.example.criminalintent.Fragment

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.example.criminalintent.Data.Crime
import com.example.criminalintent.databinding.CriminalIntentLayoutBinding
import java.util.Date
import java.util.UUID

class CrimeDetailFragment : Fragment() {

    private lateinit var crime: Crime
    private lateinit var binding: CriminalIntentLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

       binding = CriminalIntentLayoutBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        crime = Crime(
            crimeID = UUID.randomUUID(),
            title = "some title",
            date = Date(),
            isSolved = true
        )
        updateUI()
    }

  private fun updateUI(){
      
      binding.editText.doOnTextChanged { text, _, _, _ ->
          //check whether the text entered by the user is different from the current text
          if(binding.editText.text.toString() != text.toString()){
              binding.editText.text = text as Editable?
          }
      }

  }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)

    //TODO: initialise the crime object
//    }
}