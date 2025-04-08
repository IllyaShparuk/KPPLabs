import java.util.Scanner;

public class Main {
    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        long num1, num2;
        try {
            num1 = Long.parseLong(args[0]);
            num2 = Long.parseLong(args[1]);
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введіть перше число: ");
            num1 = scanner.nextLong();
            System.out.print("Введіть друге число: ");
            num2 = scanner.nextLong();
            scanner.close();
        }
        long result = gcd(num1, num2);
        System.out.println("Найбільший спільний дільник (НСД) чисел " + num1 + " і " + num2 + " = " + result);
    }


}