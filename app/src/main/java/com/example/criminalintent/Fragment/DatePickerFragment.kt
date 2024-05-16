package com.example.criminalintent.Fragment

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.util.Calendar
import java.util.Date
import java.util.GregorianCalendar

private const val RESULT_DATE_KEY = "resultDate"
class DatePickerFragment : DialogFragment() {


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val year: Int = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val dateListener = DatePickerDialog.OnDateSetListener { _, year: Int, month: Int, day: Int ->
            val resultDate : Date = GregorianCalendar(year,month,day).time
         val result = Bundle().apply {
             putSerializable(RESULT_DATE_KEY,resultDate)
         }

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