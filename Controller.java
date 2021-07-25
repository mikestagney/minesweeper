package minesweeper;

import java.util.Scanner;

public class Controller {

    Scanner input;
    Board board;

    Controller() {
        input = new Scanner(System.in);
        System.out.println("How many mines do you want on the field?");
        int mines = Integer.parseInt(input.nextLine());
        board = new Board(mines);
    }

    public void runGame() {

        System.out.println(board);
        System.out.println("Set/delete mines marks (x and y coordinates):");
        String[] coordinates = input.nextLine().split(" ");
        int row = Integer.parseInt(coordinates[1]);
        int col = Integer.parseInt(coordinates[0]);

    }




}
