@file:Suppress("DEPRECATION")

package com.m1ctopt1.myunitconverter

import org.junit.Assert.assertEquals

import org.junit.Test

class ConversionTester {
    data class Unit(val name: String, val converionFactor: Double){
        override fun toString(): String {
            return name
        }
    }

    val lengthUnits = listOf(
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

    @Test
    fun convert() {
        val u1 = lengthUnits[0]
        val u2 = lengthUnits[1]
        val value: Double= 1200.0

        assertEquals(1.2, convert(u1,u2,value), 0.0)

    }
    @Test
    fun convert2(){
        val u3 = temperatureUnits[0]
        val u4 = temperatureUnits[1]
        assertEquals(212.0, convert(u3,u4,100.0), 0.0)
    }
    @Test
    fun convert3(){
        val u5 = massUnits[0]
        val u6 =massUnits[1]
        assertEquals(0.1, convert(u6,u5,100.0), 0.0)
    }

}