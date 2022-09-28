package game.hangman;

import java.util.HashSet;
import java.util.Set;

public class Player {
    private int lives;
    private Set<Character> guessesMade;

    public Player(int lives) {
        this.lives = lives;
        guessesMade = new HashSet<>();
    }

    public int getLives() {
        return lives;
    }

    public boolean isGuessValid(char guess){
        return !guessesMade.contains(guess);
    }

    public void addGuess(char guess){
        guessesMade.add(guess);
    }

    public void removeLife(){
        lives--;
    }

    public boolean isLost(){
        return lives < 0;
    }

    public Set<Character> getGuessesMade() {
        return guessesMade;
    }
}
