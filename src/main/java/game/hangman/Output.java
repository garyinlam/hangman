package game.hangman;

import java.util.Arrays;
import java.util.Set;

public class Output {
    // display the word, either the letter or _ depending on if guessed
    public static void displayWord(String word,boolean[] guesses){
        System.out.println();
        for (int i = 0; i < word.length(); i++) {
            if (guesses[i]){
                System.out.print(word.toUpperCase().charAt(i));
            } else {
                System.out.print("_");
            }
        }
    }

    //show guesses made
    public static void displayGuessed(Set<Character> guessed) {
        System.out.print("Guessed letters: ");
        char[] sorted = new char[guessed.size()];

        int i = 0;
        for (char guess: guessed) {
            sorted[i] = guess;
            i++;
        }
        Arrays.sort(sorted);
        for (char guess:sorted) {
            System.out.print(guess + " ");
        }
    }

    // display at start of each turn
    public static void displayTurn(Player player, Word word){
        System.out.println(player.getLives() + " wrong guesses remaining");
        displayGuessed(player.getGuessesMade());
        displayWord(word.getWord(),word.getCorrectGuesses());
        System.out.println("\nMake a guess");
    }

    public static void drawStick(int lives) {
        switch (lives){
            case 10:
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                break;
            case 9:
                System.out.println();
                System.out.println();
                System.out.println("      O");
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                break;
            case 8:
                System.out.println();
                System.out.println();
                System.out.println("      O");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println();
                System.out.println();
                System.out.println();
                break;
            case 7:
                System.out.println();
                System.out.println();
                System.out.println("      O");
                System.out.println("     -|");
                System.out.println("      |");
                System.out.println();
                System.out.println();
                System.out.println();
                break;
            case 6:
                System.out.println();
                System.out.println();
                System.out.println("      O");
                System.out.println("     -|-");
                System.out.println("      |");
                System.out.println();
                System.out.println();
                System.out.println();
                break;
            case 5:
                System.out.println();
                System.out.println();
                System.out.println("      O");
                System.out.println("     -|-");
                System.out.println("      |");
                System.out.println("     /");
                System.out.println();
                System.out.println();
                break;
            case 4:
                System.out.println();
                System.out.println();
                System.out.println("      O");
                System.out.println("     -|-");
                System.out.println("      |");
                System.out.println("     / \\");
                System.out.println();
                System.out.println();
                break;
            case 3:
                System.out.println();
                System.out.println();
                System.out.println("      O");
                System.out.println("     -|-");
                System.out.println("      |");
                System.out.println("     / \\");
                System.out.println();
                System.out.println("-----");
                break;
            case 2:
                System.out.println();
                System.out.println("  |");
                System.out.println("  |   O");
                System.out.println("  |  -|-");
                System.out.println("  |   |");
                System.out.println("  |  / \\");
                System.out.println("  |");
                System.out.println("-----");
                break;
            case 1:
                System.out.println("  -----");
                System.out.println("  |/");
                System.out.println("  |   O");
                System.out.println("  |  -|-");
                System.out.println("  |   |");
                System.out.println("  |  / \\");
                System.out.println("  |");
                System.out.println("-----");
                break;
            case 0:
                System.out.println("  -----");
                System.out.println("  |/  |");
                System.out.println("  |   O");
                System.out.println("  |  -|-");
                System.out.println("  |   |");
                System.out.println("  |  / \\");
                System.out.println("  |");
                System.out.println("-----");
                break;
            default:
                System.out.println("  -----");
                System.out.println("  |/  |");
                System.out.println("  |   O   snap!");
                System.out.println("  |  -|-");
                System.out.println("  |   |");
                System.out.println("  |  / \\");
                System.out.println("  |");
                System.out.println("-----");
                break;
        }
    }
}
