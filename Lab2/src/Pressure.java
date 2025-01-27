public class Pressure extends Unit {
    Pressure() {
        units.put("fromPascalToPSI", pascal -> pascal * 0.000145037738);
        units.put("fromPSIToPascal", psi -> psi * 6894.7572932);
        units.put("fromPascalToMbar", pascal -> pascal * 0.01);
        units.put("fromMbarToPascal", mbar -> mbar * 100);
        units.put("fromPSIToMbar", psi -> psi * 68.947572932);
        units.put("fromMbarToPSI", mbar -> mbar * 0.0145037738);
    }
}
