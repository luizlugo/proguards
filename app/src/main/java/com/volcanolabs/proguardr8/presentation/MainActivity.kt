package com.volcanolabs.proguardr8.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.volcanolabs.proguardr8.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainActivityListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun setActionBarTitle(title: String) {
        val actionBar = supportActionBar
        actionBar?.title = title
    }
}