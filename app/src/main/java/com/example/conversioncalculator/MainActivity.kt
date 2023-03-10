package com.example.conversioncalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.conversioncalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Spinner
        ArrayAdapter.createFromResource(
            this,
            R.array.unit_array,
            R.layout.spinner_style
        ).also { adapter ->
            adapter.setDropDownViewResource(R.layout.dropdown_style)
            binding.unitSpinner.adapter = adapter
        }
        binding.unitSpinner.onItemSelectedListener = this

        // Convert button
        binding.convertButton.setOnClickListener {
            conversion()
        }
        // Clear button
        binding.clearButton.setOnClickListener {
            binding.inputEditText.text.clear()
            binding.outputValueTextView.text = "0"
        }
    }

    //Spinner
    override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
        // Do nothing
    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        // Do nothing
    }

    //Conversion
    private fun conversion() {
        val selectedItem = binding.unitSpinner.selectedItem as String

        val inputValue = binding.inputEditText.text.toString().toDoubleOrNull() ?: return

        var convertedValue = 0.0
        when (selectedItem) {
            "km to mi" -> convertedValue = inputValue * 0.62
            "mi to km" -> convertedValue = inputValue * 1.61
            "cm to in" -> convertedValue = inputValue * 0.39
            "in to cm" -> convertedValue = inputValue * 2.54
            "kg to lb" -> convertedValue = inputValue * 2.2
            "lb to kg" -> convertedValue = inputValue * 0.45
            "g to oz" -> convertedValue = inputValue * 0.04
            "oz to g" -> convertedValue = inputValue * 28.35
            "l to cups" -> convertedValue = inputValue * 4.17
            "cup to l" -> convertedValue = inputValue * 0.24
        }
        //Display
        binding.outputValueTextView.text = String.format("%.2f", convertedValue)
    }

}

