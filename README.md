# Hangman - Java Terminal

A hangman game created in Java to be played in the terminal

The player can choose how many lives they would like to have (max 10).

Player can then choose the category of words they would like to appear.

> Files containing words are stored in wordLists folder
> - words may contain non-alphabetical characters, these will be shown to the player and do not need to be guessed

The player then chooses letters to be put into the game.

Any letter that shows up in the world will be displayed to the player.

The player cannot make a guess that is:
- non-alphabetical
- previously guessed
- more than one character

If a wrong guess is made, the player loses a life and some ASCII art is drawn.

The game ends if the word is guessed or the player runs out of lives.

## Screenshot
![Screenshot](/screenshots/Screenshot%202022-10-03%20144322.jpg)