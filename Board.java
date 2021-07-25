package minesweeper;

import java.awt.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Board {

    final char MINE = 'X';
    final char SAFE = '.';
    final int SIZE = 9;
    char[][] board;
    Set<Point> mineLocations;
    Set<Point> userGuesses;

    Board(int mines) {
        board = new char[SIZE][SIZE];
        mineLocations = new HashSet<>();
        userGuesses = new HashSet<>();
        fillBoardSafe();
        addMines(mines);
        addHints();
    }
    private void fillBoardSafe() {
        for (char[] row : board) {
            Arrays.fill(row, SAFE );
        }
    }
    private void addMines(int mines) {
        Random random = new Random();
        while (mines > 0) {
            int row = random.nextInt(SIZE);
            int col = random.nextInt(SIZE);
            if (board[row][col] != MINE) {
                board[row][col] = MINE;
                mineLocations.add(new Point(row, col));
                mines--;
            }
        }
    }
    private void addHints() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == MINE) {
                    continue;
                }
                int minesCount = 0;
                if (checkForMine(row - 1, col)) {
                    minesCount++;
                }
                if (checkForMine(row + 1, col)) {
                    minesCount++;
                }
                if (checkForMine(row, col - 1)) {
                    minesCount++;
                }
                if (checkForMine(row, col + 1)) {
                    minesCount++;
                }
                if (checkForMine(row - 1, col - 1)) {
                    minesCount++;
                }
                if (checkForMine(row - 1, col + 1)) {
                    minesCount++;
                }
                if (checkForMine(row + 1, col - 1)) {
                    minesCount++;
                }
                if (checkForMine(row + 1, col + 1)) {
                    minesCount++;
                }
                if (minesCount > 0) {
                    board[row][col] = Character.forDigit(minesCount, 10);
                }
            }
        }

    }
    private boolean checkForMine(int row, int col) {
        return row >= 0 && row < SIZE &&
            col >= 0 && col < SIZE &&
                board[row][col] == MINE;
    }
    public boolean checkForNumber(int row, int col) {
        return board[row][col] >= '1' && board[row][col] <= '9';
    }
    public boolean checkForWin() {
        return mineLocations.equals(userGuesses);
    }
    public void handleUserChoice(int row, int col) {
        Point choice = new Point(row, col);

        if (userGuesses.contains(choice)) {
            userGuesses.remove(choice);
        } else {
            userGuesses.add(choice);
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
                if (board[row][col] == MINE) {
                    builder.append(SAFE);
                } else {
                    builder.append(board[row][col]);
                }
            }
            builder.append("|\n");
        }
        builder.append(topBottomHeader);
        return builder.toString();
    }
}
