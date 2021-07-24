package minesweeper;

import java.util.Arrays;
import java.util.Random;

public class Board {

    final char MINE = 'X';
    final char SAFE = '.';
    final int SIZE = 9;
    char[][] board;

    Board(int mines) {
        board = new char[SIZE][SIZE];
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
                mines--;
            }
        }
    }
    private void addHints() {



    }





    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (char[] row : board) {
            for (char columnSquare : row) {
                builder.append(columnSquare);
            }
            builder.append("\n");
        }
        return builder.toString();
    }

}
