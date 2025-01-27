public class Temperature extends Unit {
    Temperature() {
        units.put("fromCelsiusToFahrenheit", celsius -> celsius * (9 / 5) + 32);
        units.put("fromFahrenheitToCelsius", fahrenheit -> (fahrenheit - 32) * (5 / 9));
        units.put("fromCelsiusToKelvin", celsius -> celsius + 273.15);
        units.put("fromKelvinToCelsius", kelvin -> kelvin - 273.15);
        units.put("fromFahrenheitToKelvin", fahrenheit -> (5 / 9) * (fahrenheit + 459.67));
        units.put("fromKelvinToFahrenheit", kelvin -> (9 / 5) * kelvin - 459.67);
    }
}
