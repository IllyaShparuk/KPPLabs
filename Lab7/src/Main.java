import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int SIZE = 15;
    private static final char EMPTY = '.';
    private static char PLAYER = 'X';
    private static char COMPUTER = 'O';
    private static final char[][] board = new char[SIZE][SIZE];
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        initializeBoard();
        printBoard();
        boolean coin = coinToss();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (coin) {
                playerMove(scanner);
                printBoard();
                if (checkWin(PLAYER)) {
                    System.out.println("Ви виграли!");
                    break;
                }

                computerMove();
                printBoard();
                if (checkWin(COMPUTER)) {
                    System.out.println("Комп'ютер виграв!");
                    break;
                }
            } else {
                computerMove();
                printBoard();
                if (checkWin(COMPUTER)) {
                    System.out.println("Комп'ютер виграв!");
                    break;
                }

                playerMove(scanner);
                printBoard();
                if (checkWin(PLAYER)) {
                    System.out.println("Ви виграли!");
                    break;
                }
            }
        }
        scanner.close();
    }

    private static void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    private static void printBoard() {
        int indent = indentCalculation();
        String format = "%" + indent + "d";
        System.out.print(" ".repeat(indent));
        for (int i = 0; i < SIZE; i++) {
            System.out.printf(format + " ", i);
        }
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.printf(format + " ", i);
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ".repeat(indent));
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int indentCalculation() {
        return (int) Math.log10(SIZE) + 1;
    }


    private static boolean coinToss() {
        int rand = RANDOM.nextInt(2);
        if (rand == 0) {
            System.out.println("Першим є ВАШ хід (Ви граєте X)");
            PLAYER = 'X';
            COMPUTER = 'O';
            return true;
        } else {
            System.out.println("Першим є хід комп'ютера (Ви граєте за O)");
            PLAYER = 'O';
            COMPUTER = 'X';
            return false;
        }
    }

    private static void playerMove(Scanner scanner) {
        int row, col;
        do {
            System.out.print("Ваш хід (рядок і стовпець): ");
            row = scanner.nextInt();
            col = scanner.nextInt();
        } while (isNotValidMove(row, col));
        board[row][col] = PLAYER;
    }

    private static void computerMove() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == EMPTY) {
                    board[i][j] = COMPUTER;
                    if (checkWin(COMPUTER)) return;
                    board[i][j] = EMPTY;
                }
            }
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == EMPTY) {
                    board[i][j] = PLAYER;
                    if (checkWin(PLAYER)) {
                        board[i][j] = COMPUTER;
                        return;
                    }
                    board[i][j] = EMPTY;
                }
            }
        }


        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == COMPUTER) {
                    for (int[] dir : DIRECTIONS) {
                        int r = i + dir[0];
                        int c = j + dir[1];
                        if (r >= 0 && r < SIZE && c >= 0 && c < SIZE && board[r][c] == EMPTY) {
                            board[r][c] = COMPUTER;
                            return;
                        }
                    }
                }
            }
        }


        int row, col;
        do {
            row = RANDOM.nextInt(SIZE);
            col = RANDOM.nextInt(SIZE);
        } while (isNotValidMove(row, col));
        board[row][col] = COMPUTER;
    }

    private static boolean isNotValidMove(int row, int col) {
        return row < 0 || row >= SIZE || col < 0 || col >= SIZE || board[row][col] != EMPTY;
    }

    private static boolean checkWin(char symbol) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (checkDirection(i, j, 1, 0, symbol) ||
                        checkDirection(i, j, 0, 1, symbol) ||
                        checkDirection(i, j, 1, 1, symbol) ||
                        checkDirection(i, j, 1, -1, symbol)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkDirection(int row, int col, int dRow, int dCol, char symbol) {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            int r = row + i * dRow;
            int c = col + i * dCol;
            if (r >= 0 && r < SIZE && c >= 0 && c < SIZE && board[r][c] == symbol) {
                count++;
            } else {
                break;
            }
        }
        return count == 5;
    }
}