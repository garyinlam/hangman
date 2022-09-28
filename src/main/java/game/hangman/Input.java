package game.hangman;

import java.util.Scanner;

public class Input {
    // get character that player guesses
    public static char getGuess(Scanner scanner) {
        String input = scanner.nextLine().toLowerCase();
        boolean validInput = false;
        while (!validInput) {
            if (input.length() != 1) {
                System.out.println("Please only input one character");
                input = scanner.nextLine().toLowerCase();
            } else if (input.matches("[a-z]")) {
                validInput = true;
            } else {
                System.out.println("Please only input valid characters (a-z)");
                input = scanner.nextLine().toLowerCase();
            }
        }
        return input.charAt(0);
    }

    // check if player enters y or n
    public static boolean playAgain(Scanner scanner){
        String input = scanner.nextLine().toLowerCase();
        boolean retVal = false;
        boolean validInput = false;
        while (!validInput){
            if (input.matches("y") || input.matches("n")) {
                validInput = true;
                retVal = input.matches("y");
            } else {
                System.out.println("Please only y or n");
                input = scanner.nextLine().toLowerCase();
            }
        }
        return retVal;
    }

    // used for game setup, change how many lives the player wants, max 10
    public static int getInt(Scanner scanner, int min, int max){
        String input = scanner.nextLine();
        int retVal = 0;
        boolean validInput = false;
        while (!validInput){
            try {
                retVal = Integer.parseInt(input);
                if (retVal > max || retVal < min) {
                    System.out.println("Please enter in an valid number ("+min+"-"+max+")");
                    input = scanner.nextLine();
                } else {
                    validInput = true;
                }
            } catch (Exception e){
                System.out.println("Please enter in an integer number only");
                input = scanner.nextLine();
            }
        }
        return retVal;
    }
}
