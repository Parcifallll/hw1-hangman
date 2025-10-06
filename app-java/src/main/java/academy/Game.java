package academy;

import java.util.Arrays;
import java.util.Scanner;

public class Game {
    private String hiddenWord;
    private char[] guessedWord;
    private int attemptsLeft = 6;

    public Game(String hiddenWord, String guessedWord) {
        this.hiddenWord = hiddenWord;
        this.guessedWord = guessedWord.toCharArray();
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

    public boolean isGuessed(char[] guessedWord) {
        for (char c : guessedWord) {
            if (c == '*') {
                return false;
            }
        }
        return true;
    }

    public boolean guess(String str) {
        boolean found = false; // correct guess
        char letter = str.charAt(0);
        for (int i = 0; i < hiddenWord.length(); i++) {
            if (hiddenWord.charAt(i) == letter) {
                guessedWord[i] = letter;
                found = true;
            }
        }

        return found;
    }

    public String letterValidation(Scanner scanner) {
        String letter;
        do {
            letter = scanner.nextLine().toLowerCase();
            if (letter.length() != 1 || !letter.matches("[а-яё]")) {
                System.out.print("Пожалуйста, введите ровно одну русскую букву: ");
            }
        } while (letter.length() != 1 || !letter.matches("[а-яё]"));
        return letter;
    }

    public void startInteractive() {
        NewGameConfigurator gameConfigurator = new NewGameConfigurator(WordList.getDict()); // start new game (choose a category, level of difficulty and word)
        String category = gameConfigurator.getCategory();
        String level = gameConfigurator.getLevel(category);
        hiddenWord = gameConfigurator.getRandomWord(category, level);
        guessedWord = new char[hiddenWord.length()];
        Arrays.fill(guessedWord, '*');
        GameVisualizer gameVisualizer = new GameVisualizer(this);
        gameVisualizer.start();
        // session visualization (hangman, guessing , attempts)

    }

    public String startNonInteractive() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < hiddenWord.length(); i++) {
            char hiddenChar = hiddenWord.charAt(i);
            if (new String(guessedWord).contains(String.valueOf(hiddenChar).toLowerCase())) {
                result.append(hiddenChar);
            } else {
                result.append('*');
            }
        }
        result.append(result.toString().contains("*") ? ";NEG" : ";POS");
        return result.toString();
    }
}

