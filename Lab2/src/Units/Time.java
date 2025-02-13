package Units;

public class Time extends Unit {
    public Time(){
        units.put("From Seconds To Minutes", seconds -> seconds / 60.0);
        units.put("From Minutes To Seconds", minutes -> minutes * 60.0);
        units.put("From Minutes To Hours", minutes -> minutes / 60.0);
        units.put("From Hours To Minutes", hours -> hours * 60.0);
        units.put("From Hours To Seconds", hours -> hours * 3600.0);
        units.put("From Seconds To Hours", seconds -> seconds / 3600.0);
    }
}
