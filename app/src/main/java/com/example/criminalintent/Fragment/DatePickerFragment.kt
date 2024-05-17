package com.example.criminalintent.Fragment

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.navArgs
import java.util.Calendar
import java.util.Date
import java.util.GregorianCalendar

private const val RESULT_DATE_KEY = "BUNDLE_KEY_DATE"
class DatePickerFragment : DialogFragment() {
    private val args: DatePickerFragmentArgs by navArgs()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        calendar.time = args.crimeDate
        val year: Int = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val dateListener = DatePickerDialog.OnDateSetListener { _, year: Int, month: Int, day: Int ->
            val resultDate : Date = GregorianCalendar(year,month,day).time

         val result = Bundle().apply {
             putSerializable(RESULT_DATE_KEY,resultDate)
         }
            // Set the fragment result, this will invoke the `onFragmentResult` of CrimeDetailFragment
            setFragmentResult("requestKey",result)
        }

        return DatePickerDialog(
            requireContext(),
            dateListener,
            year,
            month,
            day
        )
    }
}