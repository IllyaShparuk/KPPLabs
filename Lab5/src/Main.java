import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int coins = random.nextInt(31) + 10;
        boolean isUserTurn = random.nextBoolean();

        System.out.println("Початкова кількість монет: " + coins);
        System.out.println(isUserTurn ? "Ваш хід перший!" : "Комп'ютер починає!");

        while (coins > 0) {
            if (isUserTurn) {
                int userMove;
                do {
                    System.out.print("Ваш хід (1 або 2 монети): ");
                    userMove = scanner.nextInt();
                } while (userMove < 1 || userMove > 2 || userMove > coins);

                coins -= userMove;
                System.out.println("Залишилось монет: " + coins);
                if (coins == 0) {
                    System.out.println("Ви виграли!");
                    break;
                }
            } else {
                int computerMove = optimalMove(coins);
                System.out.println("Комп'ютер взяв: " + computerMove);
                coins -= computerMove;
                System.out.println("Залишилось монет: " + coins);
                if (coins == 0) {
                    System.out.println("Комп'ютер виграв!");
                    break;
                }
            }
            isUserTurn = !isUserTurn;
        }
    }

    private static int optimalMove(int coins) {
        if (coins % 3 != 0) return coins % 3;
        return new Random().nextInt(2) + 1;
    }
}