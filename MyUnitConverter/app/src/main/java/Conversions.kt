import com.m1ctopt1.myunitconverter.Unit

class Conversions {

    companion object{
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

        private fun Conversions(){
            var unit1 = lengthUnits[0]
            var unit2 = lengthUnits[1]
            var value = 12000
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



    }

}