package com.example.criminalintent

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.criminalintent.Adapter.CrimeAdapter
import com.example.criminalintent.Fragment.CrimeListFragment

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //instantiate a fragment
        val fragment = CrimeListFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,fragment).commit()


    }
}