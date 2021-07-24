package minesweeper;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("How many mines do you want on the field?");
        int mines = Integer.parseInt(input.nextLine());

        Board board = new Board(mines);
        System.out.println(board);
    }
}
