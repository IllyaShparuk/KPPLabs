public class PolynomOperations {
    public static Polynom addition(Polynom p1, Polynom p2) {
        Polynom result = new Polynom(Math.max(p1.getNumberOfCoefficients(), p2.getNumberOfCoefficients()));
        for (int i = 0; i < p1.getNumberOfCoefficients(); i++)
            result.setCoefficient(i, result.getCoefficient(i) + p1.getCoefficient(i));
        for (int i = 0; i < p2.getNumberOfCoefficients(); i++)
            result.setCoefficient(i, result.getCoefficient(i) + p2.getCoefficient(i));
        return result;
    }

    public static Polynom multiplication(Polynom p1, Polynom p2) {
        Polynom result = new Polynom(p1.getNumberOfCoefficients() + p2.getNumberOfCoefficients() - 1);
        for (int i = 0; i < p1.getNumberOfCoefficients(); i++) {
            for (int j = 0; j < p2.getNumberOfCoefficients(); j++)
                result.setCoefficient(i + j, result.getCoefficient(i + j) + (p1.getCoefficient(i) * p2.getCoefficient(j)));
        }
        return result;
    }

    public static Polynom differentiate(Polynom p) {
        Polynom result = new Polynom(p.getNumberOfCoefficients());

        for (int i = 1; i < p.getNumberOfCoefficients(); i++) {
            result.setCoefficient(i - 1, p.getCoefficient(i) * i);
        }
        return result;
    }
}
