import java.util.*;

public class Main {
    private static final int SIZE = 10;
    private static final char WATER = '~';
    private static final char SHIP = 'S';
    private static final char HIT = 'X';
    private static final char MISS = 'O';
    private static final int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}, {-1, 1}, {1, 1}, {-1, -1}, {1, -1}};

    private static final char[][] playerBoard = new char[SIZE][SIZE];
    private static final char[][] computerBoard = new char[SIZE][SIZE];
    private static final char[][] computerFog = new char[SIZE][SIZE];
    private static final Random rand = new Random();


    public static void main(String[] args) {
        initializeBoard(playerBoard);
        initializeBoard(computerBoard);
        initializeBoard(computerFog);

        placeAllShips(playerBoard);
        placeAllShips(computerBoard);

        Scanner scanner = new Scanner(System.in);
        boolean playerTurn = rand.nextBoolean();
        System.out.println("Гру починає " + (playerTurn ? "гравець" : "комп'ютер"));

        int playerShips = 20;
        int computerShips = 20;

        while (playerShips > 0 && computerShips > 0) {
            printBoards(args);

            if (playerTurn) {
                System.out.print("Ваш хід (наприклад, A5): ");
                String move = scanner.next().toUpperCase();
                int row = move.charAt(1) - '0';
                int col = move.charAt(0) - 'A';

                if (!isValid(row, col) || computerFog[row][col] == HIT || computerFog[row][col] == MISS) {
                    System.out.println("Неприпустимий хід. Спробуйте ще раз.");
                    continue;
                }
                int temp = computerShips;
                computerShips = checkForHit(computerBoard, row, col, computerShips, true);
                if (temp == computerShips) {
                    playerTurn = false;
                }
            } else {
                int row, col;
                do {
                    row = rand.nextInt(SIZE);
                    col = rand.nextInt(SIZE);
                } while (playerBoard[row][col] == HIT || playerBoard[row][col] == MISS);

                System.out.println("Комп'ютер стріляє в: " + (char) (col + 'A') + row);
                int temp = playerShips;
                playerShips = checkForHit(playerBoard, row, col, playerShips, false);
                if (temp == playerShips) {
                    playerTurn = true;
                }
            }
        }

        System.out.println(playerShips == 0 ? "Комп'ютер переміг!" : "Ви перемогли!");
    }

    private static void initializeBoard(char[][] board) {
        for (int i = 0; i < SIZE; i++)
            Arrays.fill(board[i], WATER);
    }

    private static void printBoards(String[] args) {
        System.out.println("\nВаше поле:");
        printBoard(playerBoard);
        System.out.println("\nПоле комп'ютера:");
        printBoard(computerFog);
        if (args.length > 0 && Objects.equals(args[0], "--DEBUG")) {
            System.out.println("\n\u001B[43m\u001B[30mDEBUG поле комп'ютера:");
            printBoard(computerBoard);
            System.out.print("\u001B[0m\n");
        }
    }

    private static void printBoard(char[][] board) {
        System.out.print("  ");
        for (char c = 'A'; c < 'A' + SIZE; c++)
            System.out.print(c + " ");
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isValid(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE;
    }

    private static void placeAllShips(char[][] board) {
        placeShip(board, 4, 1);
        placeShip(board, 3, 2);
        placeShip(board, 2, 3);
        placeShip(board, 1, 4);
    }

    private static void placeShip(char[][] board, int size, int count) {
        while (count > 0) {
            int row = rand.nextInt(SIZE);
            int col = rand.nextInt(SIZE);
            boolean horizontal = rand.nextBoolean();

            if (canPlaceShip(board, row, col, size, horizontal)) {
                for (int i = 0; i < size; i++) {
                    int r = row + (horizontal ? 0 : i);
                    int c = col + (horizontal ? i : 0);
                    if (r >= 0 && r < SIZE && c >= 0 && c < SIZE) {
                        board[r][c] = SHIP;
                    }
                }
                count--;

            }
        }
    }

    private static boolean canPlaceShip(char[][] board, int row, int col, int size, boolean horizontal) {
        for (int i = 0; i < size; i++) {
            int r = row + (horizontal ? 0 : i);
            int c = col + (horizontal ? i : 0);
            for (int[] dir : directions) {
                int newRow = r + dir[0];
                int newCol = c + dir[1];
                if (newRow >= 0 && newRow < SIZE && newCol >= 0 && newCol < SIZE)
                    if (board[r + dir[0]][c + dir[1]] == SHIP) {
                        return false;
                    }
            }
            if (r < 0 || r >= SIZE || c < 0 || c >= SIZE || board[r][c] != WATER) {
                return false;
            }
        }
        return true;
    }

    private static int checkForHit(char[][] board, int row, int col, int ships, boolean isPlayer) {
        if (board[row][col] == SHIP) {
            board[row][col] = HIT;
            isDestroyed(board, row, col);
            ships--;
        } else {
            System.out.println("Мимо!");
        }
        if (isPlayer) {
            if (board[row][col] == HIT) computerFog[row][col] = HIT;
            else computerFog[row][col] = MISS;
        }
        return ships;
    }

    private static void isDestroyed(char[][] board, int row, int col) {
        for (int[] i : directions) {
            if (board[row + i[0]][col + i[1]] == SHIP) {
                System.out.println("Влучив!");
                return;
            }
        }
        System.out.println("Потопив!");
    }
}
