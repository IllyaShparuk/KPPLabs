package Units;

public class Area extends Unit {
    public Area() {
        units.put("From M2 To Are", m2 -> m2 * 100);
        units.put("From Are To M2", are -> are * 0.01);
        units.put("From M2 to Yard2", m2 -> m2 * 1.1959900463);
        units.put("From Yard2 To M2", yard2 -> yard2 * 0.83612736);
        units.put("From Are To Yard2", are -> are * 119.59900463);
        units.put("From Yard2 To Are", yard2 -> yard2 * 0.0083612736);
    }
}
