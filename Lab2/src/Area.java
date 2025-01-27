public class Area extends Unit {
    Area() {
        units.put("fromM2ToAre", m2 -> m2 * 100);
        units.put("fromAreToM2", are -> are * 0.01);
        units.put("fromM2toYard2", m2 -> m2 * 1.1959900463);
        units.put("fromYard2ToM2", yard2 -> yard2 * 0.83612736);
        units.put("fromAreToYard2", are -> are * 119.59900463);
        units.put("fromYard2ToAre", yard2 -> yard2 * 0.0083612736);
    }
}
