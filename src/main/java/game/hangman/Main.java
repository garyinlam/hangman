package game.hangman;


import java.util.Scanner;

import static game.hangman.Input.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isFinished = false;
        System.out.println("Welcome to hangman!");

        while (!isFinished) {
            // game setup
            int[] gameParams = setUp(scanner);
            Game game = new Game(gameParams[0],gameParams[1]);
            game.doGame(scanner);

            // play again
            System.out.println("\nPlay again? (y/n)");
            isFinished = !playAgain(scanner);
        }

        scanner.close();
    }

    public static int[] setUp(Scanner scanner){
        int[] retVal = new int[2];
        System.out.println("How many lives would you like? (max 10)");
        retVal[0] = getInt(scanner,1,10);
        System.out.println("What category of words would you like?");
        System.out.println("1 - Normal words");
        System.out.println("2 - Movies");
        System.out.println("3 - K-pop groups");
        retVal[1] = getInt(scanner,1,3);
        return retVal;
    }
}
