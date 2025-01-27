public class Time extends Unit {
    Time(){
        units.put("fromSecondsToMinutes", seconds -> seconds / 60);
        units.put("fromMinutesToSeconds", minutes -> minutes * 60);
        units.put("fromMinutesToHours", minutes -> minutes / 60);
        units.put("fromHoursToMinutes", hours -> hours * 60);
        units.put("fromHoursToSeconds", hours -> hours * 3600);
        units.put("fromSecondsToHours", seconds -> seconds / 3600);
    }
}
