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
            System.out.println("Open a cell or flag/unflag for a mine:");

            String userChoice = "";
            while (!userChoice.matches("(?i)\\d\\s\\d\\s(open|flag)")) {
                userChoice = input.nextLine();
            }
            String[] coordinates = userChoice.split(" ");
            int row = Integer.parseInt(coordinates[1]);
            int col = Integer.parseInt(coordinates[0]);
            String moveType = coordinates[2].toLowerCase();
            if (isFirstMove) {
                Point firstSafeMove = new Point(row - 1, col - 1);
                board.finishBoardSetup(firstSafeMove);
                isFirstMove = false;
            }
            board.handleUserChoice(row - 1, col - 1, moveType);
        } while (!board.checkForWin() && !board.hitMine && !board.allFreeCellsUncovered());

        System.out.println(board);
        if (board.hitMine) {
            System.out.println("You stepped on a mine and failed!");
        } else {
                System.out.println("Congratulations! You found all the mines!");
        }
    }
}
