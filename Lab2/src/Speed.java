public class Speed extends Unit {
    Speed() {
        units.put("fromMPHToKMH", mph -> mph * 1.609344);
        units.put("fromKMHToMPH", kmh -> kmh / 1.609344);
        units.put("fromMSToKMH", ms -> ms * 3.6);
        units.put("fromKMHToMS", kmh -> kmh / 3.6);
        units.put("fromMSToMPH", ms -> ms * 2.2369);
        units.put("fromMPHToMS", mph -> mph / 2.2369);
    }
}