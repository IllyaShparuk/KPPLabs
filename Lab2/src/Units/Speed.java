package Units;

public class Speed extends Unit {
    public Speed() {
        units.put("From MPH To KMH", mph -> mph * 1.609344);
        units.put("From KMH To MPH", kmh -> kmh / 1.609344);
        units.put("From MS To KMH", ms -> ms * 3.6);
        units.put("From KMH To MS", kmh -> kmh / 3.6);
        units.put("From MS To MPH", ms -> ms * 2.2369);
        units.put("From MPH To MS", mph -> mph / 2.2369);
    }
}