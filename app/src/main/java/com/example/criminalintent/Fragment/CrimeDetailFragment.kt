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
import java.text.SimpleDateFormat
import java.util.Date
import java.util.TimeZone
import java.util.UUID

class CrimeDetailFragment : Fragment() {

    private lateinit var crime: Crime
    private  var _binding: CriminalIntentLayoutBinding? = null
    private val  binding  get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = CriminalIntentLayoutBinding.inflate(layoutInflater)
        return _binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        crime = Crime(
            crimeID = UUID.randomUUID(),
            title = "some title",
            date = "",
            isSolved = true
        )
        updateUI()
    }

    private fun updateUI() {

        _binding?.editText?.doOnTextChanged { text, _, _, _ ->
            //check whether the text entered by the user is different from the current text
            if (_binding?.editText?.text.toString() != text.toString()) {
                _binding?.editText?.text = text as Editable?
            }
        }
        val date = Date()
        _binding?.datePickerButton?.text =
            formatDateWithTimeZone(date, "yyyy-MM-dd HH:mm:ss z", "America/Los_Angeles")

        _binding?.checkbox?.setOnCheckedChangeListener { _, isChecked ->
            crime.copy(
                isSolved = isChecked
            )
        }
    }

    fun formatDateWithTimeZone(date: Date, pattern: String, timeZoneId: String): String {
        val dateFormat = SimpleDateFormat(pattern)
        dateFormat.timeZone = TimeZone.getTimeZone(timeZoneId)
        return dateFormat.format(date)
    }


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)

    //TODO: initialise the crime object
//    }


    override fun onDestroyView() {
        super.onDestroyView()
        //nulling out references to the views
        _binding = null
    }
}