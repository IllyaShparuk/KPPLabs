package Task2;

import java.util.*;

public class CustomNumberList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = -1;

        try {
            size = Integer.parseInt(args[0]);
            if (size < 1) {
                System.err.println("Значення розміру повинне бути натуральним числом [size > 1]");
                throw new NumberFormatException();
            }
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException ignored) {
        }

        while (size <= 1) {
            try {
                System.out.print("Введіть розмір масиву: ");
                size = scanner.nextInt();
                if (size <= 1) {
                    System.err.println("size > 1");
                }

            } catch (InputMismatchException e) {
                System.out.println("Введіть натуральне число.");
                scanner.nextLine();
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        int number = 1000;

        while (list.size() < size) {
            if (isValid(number)) {
                list.add(number);
            }
            number++;
        }

        System.out.println("\nСписок до сортування:");
        list.forEach(System.out::println);

        list.sort(new MyComparator());

        System.out.println("\nСписок після сортування:");
        list.forEach(System.out::println);
    }

    private static boolean isValid(int number) {
        String str = String.valueOf(number);
        if (str.length() < 4) return false;

        int sum = 0;
        for (char ch : str.toCharArray()) {
            sum += ch - '0';
        }

        return sum % 6 == 0;
    }
}

