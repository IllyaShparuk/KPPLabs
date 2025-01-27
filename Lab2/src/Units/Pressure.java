package Units;

public class Pressure extends Unit {
    public Pressure() {
        units.put("From Pascal To PSI", pascal -> pascal * 0.000145037738);
        units.put("From PSI To Pascal", psi -> psi * 6894.7572932);
        units.put("From Pascal To Mbar", pascal -> pascal * 0.01);
        units.put("From Mbar To Pascal", mbar -> mbar * 100);
        units.put("From PSI To Mbar", psi -> psi * 68.947572932);
        units.put("From Mbar To PSI", mbar -> mbar * 0.0145037738);
    }
}
