package academy;

import java.util.Scanner;

public class GameVisualizer {
    private Game game;
    private Hangman hangman;
    private Scanner scanner;

    public GameVisualizer(Game game, Hangman hangman) {
        this.game = game;
        this.hangman = hangman;
        this.scanner = new Scanner(System.in);
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
        for (int i = 0; i < game.getHiddenWord().length(); i++) {
            if (game.getHiddenWord().charAt(i) == letter) {
                game.getGuessedWord()[i] = letter;
                found = true;
            }
        }

        return found;
    }

    public void start() {
        System.out.println("У вас есть " + game.getAttemptsLeft() + " попыток. Удачи!");
        while (!isGuessed(game.getGuessedWord()) && !game.isGameOver()) {
            System.out.println("Текущее состояние слова: " + new String(game.getGuessedWord()));
            hangman.displayHangman(game.getAttemptsLeft());

            System.out.print("Введите букву: ");
            String letter = letterValidation();

            boolean correctGuess = guess(letter);

            if (correctGuess) {
                System.out.println("Вы угадали букву!");
            } else {
                game.wrongGuess();
                System.out.println("Неверно! Осталось попыток: " + game.getAttemptsLeft());
            }
        }
        hangman.displayHangman(game.getAttemptsLeft());
        if (isGuessed(game.getGuessedWord())) {
            System.out.println("Поздравляем! Вы угадали слово: " + new String(game.getGuessedWord()));
        } else {
            System.out.println("Вы проиграли! Загаданное слово: " + game.getHiddenWord());
        }
    }

    private String letterValidation() {
        String letter;
        do {
            letter = scanner.nextLine().toLowerCase();
            if (letter.length() != 1 || !letter.matches("[а-яё]")) {
                System.out.print("Пожалуйста, введите ровно одну русскую букву: ");
            }
        } while (letter.length() != 1 || !letter.matches("[а-яё]"));
        return letter;
    }
}
