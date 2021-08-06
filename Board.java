package minesweeper;

import java.awt.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Board {

    final char MINE = 'X';
    final char SAFE = '.';
    final char MARKED = '*';
    final char EXPLORED = ' ';
    final int SIZE = 9;
    char[][] gameStateBoard;
    char[][] displayBoard;
    int numberMines;
    Set<Point> mineLocations;
    Set<Point> userFlaggedLocations;
    boolean hitMine = false;

    Board(int mines) {
        gameStateBoard = new char[SIZE][SIZE];
        displayBoard = new char[SIZE][SIZE];
        mineLocations = new HashSet<>();
        userFlaggedLocations = new HashSet<>();
        numberMines = mines;
        fillBoardSafe();

    }
    private void fillBoardSafe() {
        for (int i = 0; i < SIZE; i++) {
            Arrays.fill(gameStateBoard[i], SAFE );
            Arrays.fill(displayBoard[i], SAFE);
        }
    }
    public void finishBoardSetup(Point firstMove) {
        mineLocations.add(firstMove);
        createMineLocations();
        mineLocations.remove(firstMove);
        addNumbers();
    }

    private void createMineLocations() {
        Random random = new Random();
        int minesPlaced = 0;
        while (minesPlaced < numberMines) {
            int row = random.nextInt(SIZE);
            int col = random.nextInt(SIZE);
            if (!checkForMine(row, col)) {
                mineLocations.add(new Point(row, col));
                minesPlaced++;
            }
        }
    }
    private void addNumbers() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (checkForMine(row, col)) {
                    continue;
                }
                int minesCount = 0;
                for (int i = row - 1; i < row + 2; i++) {
                    for (int j = col - 1; j < col + 2; j++) {
                        if (checkForMine(i, j)) {
                            minesCount++;
                        }
                    }
                }
                if (minesCount > 0) {
                    gameStateBoard[row][col] = Character.forDigit(minesCount, 10);
                }
            }
        }

    }
    private boolean checkForMine(int row, int col) {
        return mineLocations.contains(new Point(row, col));
    }
    public boolean checkForNumber(int row, int col) {
        return gameStateBoard[row][col] >= '1' && gameStateBoard[row][col] <= '9';
    }
    public boolean checkForWin() {
        if (mineLocations.equals(userFlaggedLocations)) {
            addAllMinesToDisplay();
        }
        return mineLocations.equals(userFlaggedLocations);
    }
    public void handleUserChoice(int row, int col, String moveType) {
        Point choice = new Point(row, col);

        if (moveType.equals("flag")) {
            if (userFlaggedLocations.contains(choice)) {
                userFlaggedLocations.remove(choice);
                displayBoard[row][col] = SAFE;
            } else {
                if (displayBoard[row][col] == EXPLORED ||
                        (displayBoard[row][col] >= '1' && displayBoard[row][col] <= '9')) {
                            System.out.println("Can't put a mine here!");
                } else {
                    userFlaggedLocations.add(choice);
                    displayBoard[row][col] = MARKED;
                }
            }
        }
        if (moveType.equals("open")) {
            if (checkForMine(row, col)) {
                hitMine = true;
                addAllMinesToDisplay();
            } else if (checkForNumber(row, col)) {
                displayBoard[row][col] = gameStateBoard[row][col];
            } else {
                clearFreeCells(row, col);
            }
        }
    }
    private void clearFreeCells(int row, int col) {
        if (row < 0 || col < 0 || row >= SIZE || col >= SIZE) {
            return;
        }
        if (checkForNumber(row, col)) {
            displayBoard[row][col] = gameStateBoard[row][col];
            return;
        }
        if (gameStateBoard[row][col] == SAFE) {
            displayBoard[row][col] = EXPLORED;
            gameStateBoard[row][col] = EXPLORED;
            clearFreeCells(row - 1, col);
            clearFreeCells(row, col - 1);
            clearFreeCells(row + 1, col);
            clearFreeCells(row, col + 1);
            clearFreeCells(row + 1, col + 1);
            clearFreeCells(row + 1, col - 1);
            clearFreeCells(row - 1, col + 1);
            clearFreeCells(row - 1, col - 1);
        }
    }
    private void addAllMinesToDisplay() {
        for (Point mine : mineLocations) {
            displayBoard[mine.x][mine.y] = MINE;
        }
    }
    public boolean allFreeCellsUncovered() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (displayBoard[row][col] == SAFE && !checkForMine(row, col)) {
                    return false;
                }
            }
        }
        addAllMinesToDisplay();
        return true;
    }

    public String toString() {
        String divider = "-|---|---|---|---|---|---|---|---|---|\n";
        String blankSpace = " ";
        StringBuilder builder = new StringBuilder();
        builder.append(" | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |\n");
        builder.append(divider);
        for (int row = 0; row < SIZE; row++) {
            builder.append(row + 1);
            builder.append("|");
            for (int col = 0; col < SIZE; col++) {
                builder.append(blankSpace);
                builder.append(displayBoard[row][col]);
                builder.append(blankSpace);
                builder.append("|");
            }
            builder.append("\n");
            builder.append(divider);
        }
        return builder.toString();
    }
}
