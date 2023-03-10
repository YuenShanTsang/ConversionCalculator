package com.example.conversioncalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    val number = 1
    val convertedValue = number * 0.62

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Spinner
        val unitSpinner: Spinner = findViewById(R.id.unit_spinner)

        //Spinner adapter
        ArrayAdapter.createFromResource(
            this,
            R.array.unit_array,
            R.layout.spinner_style
        ).also { adapter ->
            adapter.setDropDownViewResource(R.layout.dropdown_style)
            unitSpinner.adapter = adapter
        }

        unitSpinner.onItemSelectedListener = this




    }

    //Spinner
    override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
        val selectedItem = parent.getItemAtPosition(pos) as String
        val inputNumber =
        var convertedValue = 0.0
            when(selectedItem){
            "km to mi" -> convertedValue = ${number*0.62}mi"
        }

        val resultTextView = findViewById(R.id.outputValue_text_view)
        resultTextView.text = convertedValue.toString()
    }
    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        // Do nothing
    }


}