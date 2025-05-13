package Task1;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class NaturalArrayCreator {
    public static void main(String[] args) {
        System.out.println("""
                Режими роботи:
                    1 - рандомні натуральні числа;
                    2 - натуральні числа за порядком.
                """);

        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        int size = -1, mode = -1, lim = -1;

        try {
            size = Integer.parseInt(args[0]);
            mode = Integer.parseInt(args[1]);
            if (mode == 1)
                lim = Integer.parseInt(args[2]);
        } catch (Exception ignored) {}

        while (size <= 0 || mode < 1 || mode > 2 || (mode == 1 && lim <= 0)) {
            try {
                System.out.print("Введіть режим (1 або 2): ");
                mode = scanner.nextInt();

                System.out.print("Введіть розмір масиву: ");
                size = scanner.nextInt();

                if (mode == 1) {
                    System.out.print("Введіть ліміт: ");
                    lim = scanner.nextInt();
                }

                if (size <= 0 || (mode == 1 && lim <= 0)) {
                    System.err.println("Розмір і ліміт мають бути додатні.");
                }

            } catch (InputMismatchException e) {
                System.err.println("Введіть натуральне число.");
                scanner.nextLine();
            }
        }

        scanner.close();


        final int finalSize = size; //
        final int finalMode = mode; // Щоб компліятор не сварився через "local variables referenced from a lambda expression must be final or effectively final"
        final int finalLim = lim;   //
        int[] array = new int[finalSize];
        Thread evenIndexThread = new Thread(() -> {
            for (int i = 0; i < finalSize; i += 2) {
                if (finalMode == 1) {
                    array[i] = rand.nextInt(finalLim) + 1;
                } else {
                    array[i] = i + 1;
                }
            }
        });

        Thread oddIndexThread = new Thread(() -> {
            for (int i = 1; i < finalSize; i += 2) {
                if (finalMode == 1) {
                    array[i] = rand.nextInt(finalLim) + 1;
                } else {
                    array[i] = i + 1;
                }
            }
        });

        evenIndexThread.start();
        oddIndexThread.start();

        try {
            evenIndexThread.join();
            oddIndexThread.join();
        } catch (InterruptedException ignored) {}

        System.out.print("Масив після заповнення: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
