import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private final String[] choices = {"Криниця", "Ножиці", "Папір"};
    private final Random random = new Random();
    private static final String HISTORY_FILE = "game_history.txt";
    private HashMap<String, Integer> globalHistory;

    public Game() {
        int totalWins = 0;
        int totalLosses = 0;
        final int[][] winMatrix = {{0, 1, -1}, {-1, 0, 1}, {1, -1, 0}};
        Scanner scanner = new Scanner(System.in);
        while (true) {
            globalHistory = loadGlobalHistory();
            System.out.print("Введіть кількість сеансів гри: ");
            int rounds = scanner.nextInt();
            System.out.print("Оберіть режим гри (1 - випадково, 2 - поточний сеанс, 3 - історія): ");
            int mode = scanner.nextInt();
            scanner.nextLine();

            HashMap<String, Integer> history = loadHistory(mode);
            int userWins = 0, computerWins = 0;
            for (int i = 0; i < rounds; i++) {
                System.out.print("Ваш хід (0-Криниця, 1-Ножиці, 2-Папір): ");
                int userChoice = scanner.nextInt();

                if (userChoice < 0 || userChoice > 2) {
                    System.out.println("Некоректний вибір! Спробуйте ще раз.");
                    i--;
                    continue;
                }

                int computerChoice = (mode == 1) ? random.nextInt(3) : calculateMove(history);
                System.out.println("Комп'ютер обрав: " + choices[computerChoice]);

                int result = winMatrix[userChoice][computerChoice];
                if (result == 1) {
                    System.out.println("Ви виграли!");
                    userWins++;
                } else if (result == -1) {
                    System.out.println("Комп'ютер виграв!");
                    computerWins++;
                } else {
                    System.out.println("Нічия! Граємо ще раз...");
                }
                history.put(choices[userChoice], history.getOrDefault(choices[userChoice], 0) + 1);
            }

            saveHistory(history);
            System.out.println("\nРезультати: Ви - " + userWins + " | Комп'ютер - " + computerWins);
            totalWins += userWins;
            totalLosses += computerWins;
            System.out.println("Всього виграно: \t" + totalWins + "\nПрограно: \t" + totalLosses);
            System.out.println("Хочете продовжити? (q - вийти)");
            String answ = scanner.next().toLowerCase();
            if (answ.equals("q")) {
                break;
            }
        }
    }

    private HashMap<String, Integer> loadGlobalHistory() {
        HashMap<String, Integer> history = new HashMap<>(Map.of(choices[0], 0, choices[1], 0, choices[2], 0));
        try (BufferedReader reader = new BufferedReader(new FileReader(HISTORY_FILE))) {
            reader.lines().forEach(line -> {
                String[] chunks = line.split(": ");
                if (chunks.length == 2) history.put(chunks[0], Integer.parseInt(chunks[1]));
            });
        } catch (IOException | NumberFormatException e) {
            System.err.println("Помилка читання історії: " + e.getMessage());
        }

        return history;
    }

    private HashMap<String, Integer> loadHistory(int mode) {
        HashMap<String, Integer> history = new HashMap<>(Map.of(choices[0], 0, choices[1], 0, choices[2], 0));
        if (mode != 3) return history;
        return globalHistory;
    }

    private void saveHistory(HashMap<String, Integer> history) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(HISTORY_FILE))) {
            history.forEach((key, value) -> {
                try {
                    int valSum = value + globalHistory.get(key);
                    writer.write(key + ": " + valSum + "\n");
                } catch (IOException ignored) {
                }
            });
        } catch (IOException ignored) {
        }
    }

    private int calculateMove(HashMap<String, Integer> history) {
        int total = history.values().stream().mapToInt(Integer::intValue).sum();
        double randomChoice = random.nextDouble() * total;
        double cumulative = 0.0;

        for (int i = 0; i < choices.length; i++) {
            cumulative += history.get(choices[i]);
            if (randomChoice < cumulative) return counterMove(i);
        }

        return counterMove(random.nextInt(3));
    }

    private int counterMove(int move) {
        return switch (move) {
            case 0 -> 2;
            case 1 -> 0;
            case 2 -> 1;
            default -> throw new IllegalStateException("Неочікуваний хід: " + move);
        };
    }
}
