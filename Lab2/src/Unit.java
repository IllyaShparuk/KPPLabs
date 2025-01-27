import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public abstract class Unit {
    protected Map<String, Function<Double, Double>> units = new HashMap<>();

    public double convert(double value, String fromUnit) {
        return units.getOrDefault(fromUnit, _ -> -1.0).apply(value);
    }
}
