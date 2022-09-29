package game.hangman;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    private Player player;

    @BeforeEach
    public void setUp(){
        player = new Player(7);
    }

    @Test
    public void isGuessValid_ValidGuess_ReturnsTrue(){
        assertTrue(player.isGuessValid('a'));
    }

    @Test
    public void isGuessValid_InvalidGuess_ReturnsFalse(){
        player.addGuess('a');
        assertFalse(player.isGuessValid('a'));
    }

    @Test
    public void addGuess_ValidInput_AddsGuess(){
        assertEquals(0, player.getGuessesMade().size());
        player.addGuess('a');
        assertEquals(1, player.getGuessesMade().size());
        assertTrue(player.getGuessesMade().contains('a'));
    }

    @Test
    public void removeLife_Call_DecrementsLives() {
        assertEquals(7,player.getLives());
        player.removeLife();
        assertEquals(6,player.getLives());
    }

    @Test
    public void isLost_MoreThan0Lives_ReturnsFalse() {
        player.removeLife();
        player.removeLife();
        player.removeLife();
        player.removeLife();
        player.removeLife();
        player.removeLife();
        assertEquals(1,player.getLives());
        assertFalse(player.isLost());
        player.removeLife();
        assertEquals(0,player.getLives());
        assertFalse(player.isLost());
    }

    @Test
    public void isLost_LessThan0Lives_ReturnsTrue() {
        player.removeLife();
        player.removeLife();
        player.removeLife();
        player.removeLife();
        player.removeLife();
        player.removeLife();
        player.removeLife();
        player.removeLife();
        assertEquals(-1,player.getLives());
        assertTrue(player.isLost());
    }

}