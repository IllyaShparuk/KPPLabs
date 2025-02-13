package Units;

public class Temperature extends Unit {
    public Temperature() {
        units.put("From Celsius To Fahrenheit", celsius -> celsius * (9.0 / 5.0) + 32.0);
        units.put("From Fahrenheit To Celsius", fahrenheit -> (fahrenheit - 32.0) * (5.0 / 9.0));
        units.put("From Celsius To Kelvin", celsius -> celsius + 273.15);
        units.put("From Kelvin To Celsius", kelvin -> kelvin - 273.15);
        units.put("From Fahrenheit To Kelvin", fahrenheit -> (5.0 / 9.0) * (fahrenheit + 459.67));
        units.put("From Kelvin To Fahrenheit", kelvin -> (9.0 / 5.0) * kelvin - 459.67);
    }
}
