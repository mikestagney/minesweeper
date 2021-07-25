package minesweeper;

import java.lang.management.GarbageCollectorMXBean;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Controller gameController = new Controller();
        gameController.runGame();

    }
}
