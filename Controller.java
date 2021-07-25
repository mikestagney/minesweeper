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
        while (!board.checkForWin()) {
            System.out.print(board);
            System.out.println("Set/delete mines marks (x and y coordinates):");
            boolean inputOkay = false;
            int row = 1;
            int col = 1;
            while (!inputOkay) {
                String[] coordinates = input.nextLine().split(" ");
                row = Integer.parseInt(coordinates[1]);
                col = Integer.parseInt(coordinates[0]);
                if (!board.checkForNumber(row - 1, col - 1)) {
                    inputOkay = true;
                } else {
                    System.out.println("There is a number there");
                }
            }
            board.handleUserChoice(row - 1, col - 1);

        }
        System.out.println(board);
        System.out.println("Congratulations! You found all the mines!");
    }




}
