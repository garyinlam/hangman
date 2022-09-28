package game.hangman;

public class Word {
    private String word;
    private int length;
    private boolean[] correctGuesses;

    public Word(String word) {
        this.word = word;
        this.length = word.length();
        this.correctGuesses = new boolean[length];
        for (int i = 0; i < word.length(); i++) {
            if (!(word.charAt(i)+"").matches("[a-z]")){
                correctGuesses[i] = true;
            }
        }
    }

    public boolean isGuessed(){
        boolean retVal = true;
        for (boolean guess: correctGuesses) {
            if (!guess) {
                retVal = false;
                break;
            }
        }
        return retVal;
    }

    public boolean makeGuess(char guess){
        boolean correctGuess = false;
        if (word.contains(""+guess)) {
            correctGuess = true;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guess){
                    correctGuesses[i] = true;
                }
            }
        }
        return correctGuess;
    }

    public String getWord() {
        return word;
    }

    public boolean[] getCorrectGuesses() {
        return correctGuesses;
    }
}
