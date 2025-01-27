public class Volume extends Unit {
    Volume() {
        units.put("fromM3ToGallon", m3 -> m3 * 264.1720524);
        units.put("fromGallonToM3", gallon -> gallon * 0.003785411784);
        units.put("fromM3ToLitres", m3 -> m3 * 1000);
        units.put("fromLitresToM3", litre -> litre * 0.001);
        units.put("fromGallonToLitres", gallon -> gallon * 3.785411784);
        units.put("fromLitresToGallon", litre -> litre * 0.2641720524);
    }
}
