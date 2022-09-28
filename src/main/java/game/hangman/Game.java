package game.hangman;

import java.util.Scanner;

import static game.hangman.Input.getGuess;
import static game.hangman.Output.displayTurn;
import static game.hangman.Output.drawStick;
import static game.hangman.WordUtils.*;

public class Game {
    private Player player;
    private Word word;

    public Game(int lives, int category){
        this.player = new Player(lives);
        this.word = new Word(getWord(category));
    }

    public boolean isGameOver() {
        return player.isLost() || word.isGuessed();
    }

    public Player getPlayer() {
        return player;
    }

    public Word getWordObject() {
        return word;
    }

    public void doGame(Scanner scanner){
        boolean gameOver = false;

        // game start
        while (!gameOver) {
            displayTurn(player,word);
            drawStick(player.getLives());
            char guess = getGuess(scanner);

            if (player.isGuessValid(guess)) {
                boolean correct = word.makeGuess(guess);
                player.addGuess(guess);

                if (correct) {
                    System.out.println(guess + " was correct!");
                } else {
                    player.removeLife();
                }
            } else {
                System.out.println("Already guessed " + guess + ". Try again.");
            }

            System.out.println("\b \n");
            gameOver = isGameOver();
        }

        gameOver();
    }

    private void gameOver(){
        // game over
        if (player.isLost()) {
            drawStick(-1);
            System.out.println("You lost!");
        } else {
            System.out.println("You win!\nWith " + player.getLives() + " guesses remaining!");
        }
        System.out.println("The word was: " + word.getWord());
    }
}
