package minesweeper;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        char[][] board = new char[9][9];
        Random random = new Random();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = random.nextInt(10) == 9 ? 'X' : '.';
                System.out.print(board[i][j]);
            }
            System.out.println();
        }


        
    }
}
