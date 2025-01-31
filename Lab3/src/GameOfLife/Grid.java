package GameOfLife;

import java.util.Random;

public class Grid {
    static final String ANSI_RESET = "\033[0m";
    static final String YELLOW_BACKGROUND = "\033[1;33m";
    static final String BLACK_BACKGROUND = "\033[40m";
    private int[][] grid;
    private final int rows;
    private final int cols;
    private static int liveCells;
    int[][] directions = {{0, 1}, {1, 0},
            {0, -1}, {-1, 0},
            {1, 1}, {-1, -1},
            {1, -1}, {-1, 1}};

    public Grid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        grid = new int[this.rows][this.cols];
    }

    public Grid() {
        this.rows = 10;
        this.cols = 10;
        grid = new int[this.rows][this.cols];
    }

    public int[][] getGrid() {
        return grid;
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public int getLiveCells() {
        return liveCells;
    }

    public static int[][] generateGrid(int rows, int cols) {
        Random rand = new Random();
        int[][] grid = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = rand.nextInt(2);
            }
        }
        return grid;
    }

    public int[][] nextGeneration() {
        int[][] nextGen = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int live = 0;

                // Count the number of live neighbors
                for (int[] dir : directions) {
                    int x = i + dir[0], y = j + dir[1];

                    if (x >= 0 && x < rows && y >= 0 && y < cols
                            && (grid[x][y] == 1)) {
                        live++;
                    }
                }
                countNeighbors(nextGen, live, i, j);
            }
        }
        return nextGen;
    }

    private void countNeighbors(int[][] nextGen, int live, int row, int col) {
        if (grid[row][col] == 1 && (live < 2 || live > 3)) nextGen[row][col] = 0;
        else if (grid[row][col] == 0 && live == 3) nextGen[row][col] = 1;
        else nextGen[row][col] = grid[row][col];
    }

    public static void printGrid(int[][] grid) {
        liveCells = 0;
        for (int[] row : grid) {
            for (int cell : row) {
                if (cell != 0) {
                    System.out.print(YELLOW_BACKGROUND + "*");
                    liveCells++;
                } else System.out.print(BLACK_BACKGROUND + " ");
                System.out.print(ANSI_RESET + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
