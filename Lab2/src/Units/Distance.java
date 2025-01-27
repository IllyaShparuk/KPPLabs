package Units;

public class Distance extends Unit {
    public Distance() {
        units.put("From Metres To Kilometers", meters -> meters * 0.001);
        units.put("From Kilometers To Metres", kilometres -> kilometres * 1000);
        units.put("From Kilometers To Miles", kilometres -> kilometres * 0.6213699);
        units.put("From Miles To Kilometers", miles -> miles * 1.6093472187);
        units.put("From Metres To Miles", metres -> metres * 0.0006213699);
        units.put("From Miles To Metres", miles -> miles * 1609.3472187);
    }
}
