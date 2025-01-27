public class Weight extends Unit {
    Weight(){
        units.put("fromGramsToKilograms", grams -> grams * 1000);
        units.put("fromKilogramsToGrams", kilograms -> kilograms * 0.001);
        units.put("fromPoundsToKilograms", pounds -> pounds * 0.45359237);
        units.put("fromKilogramsToPounds", kilograms -> kilograms * 2.20462262);
        units.put("fromGramsToPounds", grams -> grams * 453.59237);
        units.put("fromPoundsToGrams", pounds -> pounds * 0.00220462262);
    }
}
