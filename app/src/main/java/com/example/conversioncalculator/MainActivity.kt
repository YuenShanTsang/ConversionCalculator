package com.example.conversioncalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.conversioncalculator.databinding.ActivityMainBinding

// Add AdapterView.OnItemSelectedListener to response the spinner
class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    // Init view binding
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Setup view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup spinner
        ArrayAdapter.createFromResource(
            this,
            //Spinner items
            R.array.unit_array,
            // Changed spinner style
            R.layout.spinner_style
        ).also { adapter ->
            // Changed spinner dropdown style
            adapter.setDropDownViewResource(R.layout.dropdown_style)
            binding.unitSpinner.adapter = adapter
        }
        binding.unitSpinner.onItemSelectedListener = this

        // When clicking the Convert button, it performs the conversion function
        binding.convertButton.setOnClickListener {
            conversion()
        }
        // When clicking the Convert button, it clears the input text and returns the output to 0
        binding.clearButton.setOnClickListener {
            binding.inputEditText.text.clear()
            binding.outputValueTextView.text = "0"
        }
    }

    // Spinner functions
    override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
        // Do nothing
    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        // No action needed if nothing is selected
    }

    // Conversion function
    private fun conversion() {
        // Get the selected item from spinner
        val selectedItem = binding.unitSpinner.selectedItem

        // Get the text from the inputEditText view
        val inputText = binding.inputEditText.text.toString()

        // Convert the value to double, if cannot convert(no input/not a number), then return null
        val inputValue = inputText.toDoubleOrNull()

        // If inputValue is null, display a message and exit the function
        if (inputValue == null) {
            Toast.makeText(this, "Please enter a valid value", Toast.LENGTH_SHORT).show()
            return
        }

        // The converted value should be a double
        var convertedValue = 0.0

        // Convert the input value according to the selected item
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

        // Display the converted value with 2 sig. fig.
        binding.outputValueTextView.text = String.format("%.2f", convertedValue)
    }

}

