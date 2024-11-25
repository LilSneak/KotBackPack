package com.m1ctopt1.myunitconverter

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

data class Unit(val name: String, val converionFactor: Double){
    override fun toString(): String {
        return name
    }
}
class MainActivity : AppCompatActivity() {
    //Creating varibales for the inputs and options on conversion display
    private lateinit var categorySpinner: Spinner
    private lateinit var unitSpinnerFrom: Spinner
    private lateinit var unitSpinnerTo: Spinner
    private lateinit var inputValue: EditText
    private lateinit var convertButton: Button
    private lateinit var outputValue: TextView

    //All conversion names and factors for lengths, mass, and temperature
    private val lengthUnits = listOf(
        Unit("Meter", 1.0),
        Unit("Kilometer", 1000.0),
        Unit ("Centimeter", 0.01),
        Unit("Millimeter", 0.001),
        Unit("Mile", 1609.34),
        Unit("Yard", 0.9144),
        Unit("Foot", 0.3048),
        Unit("Inch", 0.0254)
    )
    private val massUnits = listOf(
        Unit("Kilogram", 1.0),
        Unit("Gram", 0.001),
        Unit("Milligram", 0.000001),
        Unit("Pound", 0.453592),
        Unit("Ounce", 0.0283495)
    )
    private val temperatureUnits = listOf(
        Unit("Celsius", 1.0),
        Unit("Fahrenheit", 1.0),
        Unit("Kelvin", 1.0)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //using private variables to represent the elements the user interacts with
        categorySpinner = findViewById(R.id.categorySpinner)
        unitSpinnerFrom = findViewById(R.id.unitSpinnerFrom)
        unitSpinnerTo = findViewById(R.id.unitSpinnerTo)
        inputValue = findViewById(R.id.inputValue)
        convertButton = findViewById(R.id.convertButton)
        outputValue = findViewById(R.id.resultValue)

        //Categories of conversion for the first drop down values
        val categories = listOf("Length", "Mass", "Temperature")
        //adapter is so the list can be formatted into the drop down list
        val categoryAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categories)
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        categorySpinner.adapter = categoryAdapter //setting adapter
        categorySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedCategory = categories[position]
                updateUnitSpinner(selectedCategory)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        convertButton.setOnClickListener{
            val fromUnit = unitSpinnerFrom.selectedItem as Unit
            val toUnit = unitSpinnerTo.selectedItem as Unit
            val value = inputValue.text.toString().toDoubleOrNull()
            if(value != null){
                val result = convert(fromUnit, toUnit, value)
                outputValue.text = "Result: $result ${toUnit.name}"
            }
            else{
                outputValue.text = "Please Enter a valid value"
            }
        }
    }

   fun convert(fromUnit: Unit, toUnit: Unit, value: Double): Double {
        return if(fromUnit.name=="Celsius" && toUnit.name =="Fahrenheit"){
            value * 9 / 5 + 32
        }
        else if(fromUnit.name== "Fahrenheit" && toUnit.name == "Celsius"){
            (value-32) * 5 / 9
        }
        else if(fromUnit.name== "Celsius" && toUnit.name == "Kelvin"){
            value + 273.15
        }
        else if(fromUnit.name== "Kelvin" && toUnit.name == "Celsius"){
            value - 273.15
        }
        else if(fromUnit.name== "Fahrenheit" && toUnit.name == "Kelvin"){
            (value - 32) * 5 / 9 + 273.15
        }
        else if(fromUnit.name== "Kelvin" && toUnit.name == "Fahrenheit"){
            (value - 273.15) * 9 / 5 + 32
        }
        else{
            value * fromUnit.converionFactor / toUnit.converionFactor
        }
    }

    //Update the unit category with the category selected
    private fun updateUnitSpinner(category: String) {
        val units = when(category){
            "Length" -> lengthUnits
            "Mass" -> massUnits
            "Temperature" -> temperatureUnits
            else -> emptyList()
        }
        val unitAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, units)
        unitAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        unitSpinnerFrom.adapter = unitAdapter
        unitSpinnerTo.adapter = unitAdapter
    }
}