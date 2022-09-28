package game.hangman;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class WordTest {
    private Word word;

    @BeforeEach
    public void setUp(){
        word = new Word("elephant");
    }

    @Test
    public void makeGuess_CorrectGuess_ReturnsTrue(){
        assertTrue(word.makeGuess('e'));
    }

    @Test
    public void makeGuess_CorrectGuess_ChangesCorrectGuessesArray(){
        boolean[] beforeGuess = word.getCorrectGuesses().clone();
        word.makeGuess('e');
        assertFalse(Arrays.equals(beforeGuess,word.getCorrectGuesses()));
    }

    @Test
    public void makeGuess_IncorrectGuess_ReturnsFalse(){
        assertFalse(word.makeGuess('q'));
    }

    @Test
    public void makeGuess_IncorrectGuess_DoesNotChangeCorrectGuessesArray(){
        boolean[] beforeGuess = word.getCorrectGuesses().clone();
        word.makeGuess('q');
        assertArrayEquals(beforeGuess,word.getCorrectGuesses());
    }

    @Test
    public void isGuessed_WordNotGuessed_ReturnsFalse(){
        assertFalse(word.isGuessed());
    }

    @Test
    public void isGuessed_WordGuessed_ReturnsTrue(){
        word.makeGuess('e');
        word.makeGuess('l');
        word.makeGuess('p');
        word.makeGuess('h');
        word.makeGuess('a');
        word.makeGuess('n');
        word.makeGuess('t');
        assertTrue(word.isGuessed());
    }
}