package com.example.conversioncalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fromSpinner: Spinner = findViewById(R.id.unit_spinner)

        ArrayAdapter.createFromResource(
            this,
            R.array.unit_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            fromSpinner.adapter = adapter
        }

        fromSpinner.onItemSelectedListener = this


    }
    override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
        val selectedItem = parent.getItemAtPosition(pos) as String
        // Do something with the selected item
    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        // Do nothing
    }


}