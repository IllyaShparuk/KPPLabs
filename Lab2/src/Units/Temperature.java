package Units;

public class Temperature extends Unit {
    public Temperature() {
        units.put("From Celsius To Fahrenheit", celsius -> celsius * (9 / 5) + 32);
        units.put("From Fahrenheit To Celsius", fahrenheit -> (fahrenheit - 32) * (5 / 9));
        units.put("From Celsius To Kelvin", celsius -> celsius + 273.15);
        units.put("From Kelvin To Celsius", kelvin -> kelvin - 273.15);
        units.put("From Fahrenheit To Kelvin", fahrenheit -> (5 / 9) * (fahrenheit + 459.67));
        units.put("From Kelvin To Fahrenheit", kelvin -> (9 / 5) * kelvin - 459.67);
    }
}
