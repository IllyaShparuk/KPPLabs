package Main;

import GameOfLife.Grid;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        clearConsole();
        Grid grid;

        System.out.println("Setting up grid...");
        System.out.println("Enter number of rows and number of columns of grid:");

        boolean correct = false;
        int rows = 0, columns = 0;
        while (!correct) {
            try {
                System.out.print("Rows: ");
                rows = Integer.parseInt(System.console().readLine());
                System.out.print("Columns: ");
                columns = Integer.parseInt(System.console().readLine());
                correct = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number of rows or columns!");
            }
        }
        if (rows <= 0 || columns <= 0) grid = new Grid();
        else grid = new Grid(rows, columns);
        grid.setGrid(Grid.generateGrid(grid.getRows(), grid.getCols()));
        boolean programIsRunning = true;
        do {
            grid.setGrid(grid.nextGeneration());
            Grid.printGrid(grid.getGrid());
            System.out.println("Generation #" + grid.getGeneration());
            System.out.println("Live cells: " + grid.getLiveCells());
            String c = System.console().readLine();
            clearConsole();
            if (Objects.equals(c, "")) {
                System.out.println("Next Generation");
            }
            else if (Objects.equals(c.toLowerCase(), "r")) {
                grid.resetGeneration();
                grid.setGrid(Grid.generateGrid(grid.getRows(), grid.getCols()));
            }
            else {
                programIsRunning = false;
            }
        } while (programIsRunning);
    }

    /// [Link to source](https://intellipaat.com/blog/java-clear-the-console/#method2-platform-specific-command)
    public static void clearConsole() {
        try {
            final String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (final Exception e) {
            System.err.println("Cannot clear console: " + e.getMessage());
        }
    }
}
