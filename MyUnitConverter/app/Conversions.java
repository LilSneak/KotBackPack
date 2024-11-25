public class Conversions {
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
}
