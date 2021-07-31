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
    final char EXPLORED = '/';
    final int SIZE = 9;
    char[][] board;
    char[][] displayBoard;
    int numberMines;
    Set<Point> mineLocations;
    Set<Point> userGuesses;
    boolean hitMine = false;

    Board(int mines) {
        board = new char[SIZE][SIZE];
        displayBoard = new char[SIZE][SIZE];
        mineLocations = new HashSet<>();
        userGuesses = new HashSet<>();
        numberMines = mines;
        fillBoardSafe();

    }
    private void fillBoardSafe() {
        for (int i = 0; i < SIZE; i++) {
            Arrays.fill(board[i], SAFE );
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
                    board[row][col] = Character.forDigit(minesCount, 10);
                }
            }
        }

    }
    private boolean checkForMine(int row, int col) {
        return mineLocations.contains(new Point(row, col));
    }
    public boolean checkForNumber(int row, int col) {
        return board[row][col] >= '1' && board[row][col] <= '9';
    }
    public boolean checkUserChoice(int row, int col) {
        return userGuesses.contains(new Point(row, col));
    }

    public boolean checkForWin() {
        if (mineLocations.equals(userGuesses)) {
            addAllMinesToDisplay();
        }

        return mineLocations.equals(userGuesses);
    }


    public void handleUserChoice(int row, int col, String moveType) {
        Point choice = new Point(row, col);

        if (moveType.equals("mine")) {
            if (userGuesses.contains(choice)) {
                userGuesses.remove(choice);
                displayBoard[row][col] = SAFE;
            } else {
                userGuesses.add(choice);
                displayBoard[row][col] = MARKED;
            }
        }
        if (moveType.equals("free")) {
            if (checkForMine(row, col)) {
                hitMine = true;
                addAllMinesToDisplay();
            } else if (checkForNumber(row, col)) {
                displayBoard[row][col] = board[row][col];
            } else {
                clearFreeCells(row, col);
            }
        }
    }
    private void clearFreeCells(int row, int col) {
        if (row < 0 || col < 0 || row >= SIZE || col >= SIZE) {
            return;
        }
        if (checkForMine(row, col)) {
            return;
        }
        if (checkForNumber(row, col)) {
            displayBoard[row][col] = board[row][col];
            return;
        }
        if (board[row][col] == SAFE) {
            displayBoard[row][col] = EXPLORED;
            board[row][col] = EXPLORED;
            clearFreeCells(row - 1, col);
            clearFreeCells(row, col - 1);
            clearFreeCells(row + 1, col);
            clearFreeCells(row, col + 1);
        }
    }
    private void addAllMinesToDisplay() {
        for (Point mine : mineLocations) {
            displayBoard[mine.x][mine.y] = MINE;
        }
    }

    public String toString() {
        String topBottomHeader = "-|---------|\n";
        StringBuilder builder = new StringBuilder();
        builder.append(" |123456789|\n");
        builder.append(topBottomHeader);
        for (int row = 0; row < SIZE; row++) {
            builder.append(row + 1);
            builder.append("|");
            for (int col = 0; col < SIZE; col++) {
                builder.append(displayBoard[row][col]);
            }
            builder.append("|\n");
        }
        builder.append(topBottomHeader);
        return builder.toString();
    }
}
