public class Main {
    public static void main(String[] args) {
        System.out.println("Оберіть режим роботи: ");
        System.out.println("1 - Додавання; ");
        System.out.println("2 - Множення; ");
        System.out.println("3 - Диференцювання; ");
        System.out.println("4 - Обчислення. ");
        System.out.print("Вибір: ");
        switch (System.console().readLine()) {
            case "1":
                System.out.println("Поліном 1:");
                Polynom sum_P = new Polynom();
                System.out.println("Поліном 2:");
                Polynom sum_Q = new Polynom();

                System.out.printf("P_%s(x) = ", sum_P.getNumberOfCoefficients() - 1);
                sum_P.outputCoefficients();
                System.out.printf("Q_%s(x) = ", sum_Q.getNumberOfCoefficients() - 1);
                sum_Q.outputCoefficients();

                System.out.printf("P_%s(x) + Q_%s(x) = ", sum_P.getNumberOfCoefficients() - 1, sum_Q.getNumberOfCoefficients() - 1);
                Polynom sum_res = PolynomOperations.addition(sum_P, sum_Q);
                sum_res.outputCoefficients();
                break;
            case "2":
                System.out.println("Поліном 1:");
                Polynom mult_P = new Polynom();
                System.out.println("Поліном 2:");
                Polynom mult_Q = new Polynom();

                System.out.printf("P_%s(x) = ", mult_P.getNumberOfCoefficients() - 1);
                mult_P.outputCoefficients();
                System.out.printf("Q_%s(x) = ", mult_Q.getNumberOfCoefficients() - 1);
                mult_Q.outputCoefficients();

                System.out.printf("P_%s(x) * Q_%s(x) = ", mult_P.getNumberOfCoefficients() - 1, mult_Q.getNumberOfCoefficients() - 1);
                Polynom mult_res = PolynomOperations.multiplication(mult_P, mult_Q);
                mult_res.outputCoefficients();
                break;
            case "3":
                boolean continueLoop = true;
                System.out.println("Поліном, від якого потрібно знайти похідну: ");
                Polynom p = new Polynom();
                while (continueLoop) {
                    System.out.print("P(x) = ");
                    p.outputCoefficients();

                    System.out.print("P'(x) = ");
                    Polynom diff = PolynomOperations.differentiate(p);
                    diff.outputCoefficients();
                    System.out.println("Натисніть Enter, щоб продовжити, або введіть будь-що для виходу:");
                    if (!System.console().readLine().trim().isEmpty()) {
                        continueLoop = false;

                    } else {
                        System.out.println("Задля подальшого руху по циклу P(x) = P'(x)");
                        p = diff;
                    }
                }
                break;
            case "4":
                System.out.println("Поліном: ");
                Polynom p_x = new Polynom();
                System.out.printf("P_%s(x) = ", p_x.getNumberOfCoefficients() - 1);
                p_x.outputCoefficients();

                System.out.print("Введіть значення x: ");
                double x = Double.parseDouble(System.console().readLine());
                System.out.printf("P_%s(%s) = %s", p_x.getNumberOfCoefficients() - 1, x, p_x.getResult(x));
                break;
        }
    }
}
