package game.hangman;

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
}
