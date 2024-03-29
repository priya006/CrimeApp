package com.example.criminalintent

import android.widget.CheckBox
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.criminalintent.Fragment.CrimeDetailFragment

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * We are testing CrimeDetailFragment hosted on a activity
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun testFragmentCheckBox() {
        //instance of fragment
        val fragment = launchFragmentInContainer<CrimeDetailFragment>()
        fragment.onFragment { crimeDetailFragment ->
            //Get the  view of the fragment
            val checkBox = crimeDetailFragment.requireView().findViewById<CheckBox>(R.id.checkbox)
            assertFalse(checkBox.isChecked)

        }
    }
}