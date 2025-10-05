package academy;

import java.util.Arrays;

public class Game {
    private String hiddenWord;
    private char[] guessedWord;
    private int attemptsLeft = 6;

    public Game(String hiddenWord, String guessedWord) {
        this.hiddenWord = hiddenWord.toLowerCase();
        this.guessedWord = guessedWord.toLowerCase().toCharArray();
    }

    public Game() {
    }

    public String getHiddenWord() {
        return hiddenWord;
    }

    public char[] getGuessedWord() {
        return guessedWord;
    }

    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    public boolean isGameOver() { // loss
        return attemptsLeft == 0;
    }

    public void wrongGuess() {
        attemptsLeft--;
    }

    public void startInteractive() {
        NewGameConfigurator gameConfigurator = new NewGameConfigurator(WordList.getDict()); // start new game (choose a category, level of difficulty and word)
        String category = gameConfigurator.getCategory();
        String level = gameConfigurator.getLevel(category);
        hiddenWord = gameConfigurator.getRandomWord(category, level);
        guessedWord = new char[hiddenWord.length()];
        Arrays.fill(guessedWord, '*');

        Hangman hangman = new Hangman();
        GameVisualizer interactiveGame = new GameVisualizer(this, hangman); // session visualization (hangman, guessing , attempts)
        interactiveGame.start();
    }

    public String startNonInteractive() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < hiddenWord.length(); i++) {
            char hiddenChar = hiddenWord.charAt(i);
            if (new String(guessedWord).contains(String.valueOf(hiddenChar))) {
                result.append(hiddenChar);
            } else {
                result.append('*');
            }
        }
        result.append(result.toString().contains("*") ? ";NEG" : ";POS");
        return result.toString();
    }
}

