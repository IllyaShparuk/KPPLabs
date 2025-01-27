package Units;

public class Weight extends Unit {
    public Weight(){
        units.put("From Grams To Kilograms", grams -> grams * 1000);
        units.put("From Kilograms To Grams", kilograms -> kilograms * 0.001);
        units.put("From Pounds To Kilograms", pounds -> pounds * 0.45359237);
        units.put("From Kilograms To Pounds", kilograms -> kilograms * 2.20462262);
        units.put("From Grams To Pounds", grams -> grams * 453.59237);
        units.put("From Pounds To Grams", pounds -> pounds * 0.00220462262);
    }
}
