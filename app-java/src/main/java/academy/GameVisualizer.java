package academy;

import java.util.Scanner;

public class GameVisualizer {
    private Game game;
    private Hangman hangman = new Hangman();
    private Scanner scanner;

    public GameVisualizer(Game game) {
        this.game = game;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("У вас есть " + game.getAttemptsLeft() + " попыток. Удачи!");
        while (!game.isGuessed(game.getGuessedWord()) && !game.isGameOver()) {
            System.out.println("Текущее состояние слова: " + new String(game.getGuessedWord()));
            hangman.displayHangman(game.getAttemptsLeft());
            System.out.print("Введите букву: ");
            String letter = game.letterValidation(scanner);
            boolean correctGuess = game.guess(letter);

            if (correctGuess) {
                System.out.println("Вы угадали букву!");
            } else {
                game.wrongGuess();
                System.out.println("Неверно! Осталось попыток: " + game.getAttemptsLeft());
            }
        }
        hangman.displayHangman(game.getAttemptsLeft());
        if (game.isGuessed(game.getGuessedWord())) {
            System.out.println("Поздравляем! Вы угадали слово: " + new String(game.getGuessedWord()));
        } else {
            System.out.println("Вы проиграли! Загаданное слово: " + game.getHiddenWord());
        }
    }
}
