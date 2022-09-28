package game.hangman;


import java.util.Scanner;

import static game.hangman.Input.*;
import static game.hangman.Output.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isFinished = false;
        System.out.println("Welcome to hangman!");

        while (!isFinished) {
            // game setup
            System.out.println("How many lives would you like? (max 10)");
            int lives = getInt(scanner,1,10);
            System.out.println("What category of words would you like?");
            System.out.println("1 - Normal words");
            System.out.println("2 - Movies");
            System.out.println("3 - K-pop groups");
            int category = getInt(scanner,1,3);
            Game game = new Game(lives,category);
            boolean gameOver = false;

            // game start
            while (!gameOver) {
                displayTurn(game.getPlayer(),game.getWordObject());
                drawStick(game.getPlayer().getLives());
                char guess = getGuess(scanner);

                if (game.getPlayer().isGuessValid(guess)) {
                    boolean correct = game.getWordObject().makeGuess(guess);
                    game.getPlayer().addGuess(guess);

                    if (correct) {
                        System.out.println(guess + " was correct!");
                    } else {
                        game.getPlayer().removeLife();
                    }
                } else {
                    System.out.println("Already guessed " + guess + ". Try again.");
                }

                System.out.println("\b \n");
                gameOver = game.isGameOver();
            }

            // game over
            if (game.getPlayer().isLost()) {
                drawStick(-1);
                System.out.println("You lost!");
            } else {
                System.out.println("You win!\nWith " + game.getPlayer().getLives() + " guesses remaining!");
            }
            System.out.println("The word was: " + game.getWordObject().getWord());

            // play again
            System.out.println("\nPlay again? (y/n)");
            isFinished = !playAgain(scanner);
        }

        scanner.close();
    }
}
