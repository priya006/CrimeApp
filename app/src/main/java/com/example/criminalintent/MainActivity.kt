package com.example.criminalintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.criminalintent.Fragment.CrimeDetailFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //instantiate a fragment
        val fragment = CrimeDetailFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,fragment).commit()
    }
}