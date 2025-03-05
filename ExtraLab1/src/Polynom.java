public class Polynom {
    double[] coefficients;
    int numberOfCoefficients;

    public Polynom(int n) {
        coefficients = new double[n];
        numberOfCoefficients = n;
    }

    public Polynom() {
        System.out.println("Задайте коефіцієнти для полінома: ");
        boolean success = false;
        while (!success) {
            System.out.print("\tЗадайте степінь поліному: ");
            try {
                numberOfCoefficients = Integer.parseInt(System.console().readLine()) + 1;
                coefficients = new double[numberOfCoefficients + 1];
                for (int i = 0; i < numberOfCoefficients; i++) {
                    System.out.printf("\t\tЗадайте значення для елементу %s: ", i);
                    while (true) {
                        try {
                            coefficients[i] = Double.parseDouble(System.console().readLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Спробуйте ще раз.");
                        }
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("\tНе вдалось перевести у int, спробуйте ще раз.");
            }
            success = true;
        }
    }

    void setCoefficient(int index, double coefficient) {
        coefficients[index] = coefficient;
    }

    double getCoefficient(int index) {
        return coefficients[index];
    }

    public int getNumberOfCoefficients() {
        return numberOfCoefficients;
    }

    public double getResult(double x) {
        double result = coefficients[0];
        for (int i = 1; i < numberOfCoefficients; i++) {
            result += coefficients[i] * Math.pow(x, i);
        }
        return result;
    }

    public void outputCoefficients() {
        System.out.printf("(%s)", coefficients[0]);
        for (int i = 1; i < numberOfCoefficients; i++)
            if (coefficients[i] != 0) System.out.printf("%s(%s)x^%s", " + ", coefficients[i], i);
        System.out.println();
    }
}
