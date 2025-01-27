package Units;

public class Volume extends Unit {
    public Volume() {
        units.put("From M3 To Gallon", m3 -> m3 * 264.1720524);
        units.put("From Gallon To M3", gallon -> gallon * 0.003785411784);
        units.put("From M3 To Litres", m3 -> m3 * 1000);
        units.put("From Litres To M3", litre -> litre * 0.001);
        units.put("From Gallon To Litres", gallon -> gallon * 3.785411784);
        units.put("From Litres To Gallon", litre -> litre * 0.2641720524);
    }
}
