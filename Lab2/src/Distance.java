public class Distance extends Unit {
    Distance() {
        units.put("fromMetresToKilometers", meters -> meters * 0.001);
        units.put("fromKilometersToMetres", kilometres -> kilometres * 1000);
        units.put("fromKilometersToMiles", kilometres -> kilometres * 0.6213699);
        units.put("fromMilesToKilometers", miles -> miles * 1.6093472187);
        units.put("fromMetresToMiles", metres -> metres * 0.0006213699);
        units.put("fromMilesToMetres", miles -> miles * 1609.3472187);
    }
}
