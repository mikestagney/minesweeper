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
            if (board[row][col] == SAFE) {
                board[row][col] = MINE;
                mines--;
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
