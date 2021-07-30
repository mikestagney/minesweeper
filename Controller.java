package minesweeper;

import java.awt.*;
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
        boolean isFirstMove = true;
        do {
            System.out.print(board);
            System.out.println("Set/unset mines marks or claim a cell as free:");

            String userChoice = "";
            while (!userChoice.matches("\\d\\s+\\d\\s+(free|mine)")) {
                userChoice = input.nextLine();
            }
            String[] coordinates = userChoice.split(" ");
            int row = Integer.parseInt(coordinates[1]);
            int col = Integer.parseInt(coordinates[0]);
            String type = coordinates[2];
            if (isFirstMove) {
                Point firstSafeMove = new Point(row, col);
                board.finishBoardSetup(firstSafeMove);
                isFirstMove = false;
            }

            board.handleUserChoice(row - 1, col - 1);

        } while (!board.checkForWin());

        System.out.println(board);
        System.out.println("Congratulations! You found all the mines!");
    }




}
