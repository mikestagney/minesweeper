package minesweeper;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        final int SIZE = 9;
        final char MINE = 'X';
        final char SAFE = '.';

        char[][] board = new char[SIZE][SIZE];
        System.out.println("How many mines do you want on the field?");
        int mines = Integer.parseInt(input.nextLine());

        for (char[] row : board) {
            Arrays.fill(row, SAFE );
        }

        while (mines > 0) {
            int row = random.nextInt(SIZE);
            int col = random.nextInt(SIZE);
            if (board[row][col] != MINE) {
                board[row][col] = MINE;
                mines--;
            }
        }
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == MINE) {
                    continue;
                }
                int mineCounter = 0;

                if (row - 1 >= 0) {
                    if (board[row - 1][col] == MINE) {
                        mineCounter++;
                    }
                    if (col - 1 >= 0) {
                        if (board[row - 1][col - 1] == MINE) {
                            mineCounter++;
                        }
                    }
                    if (col + 1 < SIZE) {
                        if (board[row - 1][col + 1] == MINE) {
                            mineCounter++;
                        }
                    }
                }
                if (row + 1 < SIZE) {
                    if (board[row + 1][col] == MINE) {
                        mineCounter++;
                    }
                    if (col - 1 >= 0) {
                        if (board[row + 1][col - 1] == MINE) {
                            mineCounter++;
                        }
                    }
                    if (col + 1 < SIZE) {
                        if (board[row + 1][col + 1] == MINE) {
                            mineCounter++;
                        }
                    }
                }
                if (col + 1 < SIZE) {
                    if (board[row][col + 1] == MINE) {
                        mineCounter++;
                    }
                }
                if (col - 1 >= 0) {
                    if (board[row][col - 1] == MINE) {
                        mineCounter++;
                    }
                }
                if (mineCounter > 0) {
                    board[row][col] = Character.forDigit(mineCounter, 10);
                }
            }
        }
        for (char[] row : board) {
            for (char columnSquare : row) {
                System.out.print(columnSquare);
            }
            System.out.println();
        }
    }
}
