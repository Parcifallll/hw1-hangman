package academy;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class GameVisualizerTest {

    private Game game;
    private Hangman hangman;
    private GameVisualizer visualizer;

    @BeforeEach
    public void setUp() {
        game = new Game("слово", "*****");
        hangman = new Hangman(6);
        visualizer = new GameVisualizer(game, hangman);
    }

    @Test
    public void testWordDisplayAfterCorrectGuess() {
        String simulatedInput = "с\n";
        InputStream input = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(input);

        visualizer.guess("с");
        assertEquals("с****", new String(game.getGuessedWord()));
    }



    @Test
    public void testHangmanStateAfterInvalidSymbol() {
        String simulatedInput = "1\n";
        InputStream input = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(input);

        visualizer.guess("1");
        assertEquals(6, game.getAttemptsLeft());
    }

    @Test
    public void testHangmanStateAfterUppercaseLetter() {
        String simulatedInput = "С\n";
        InputStream input = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(input);

        visualizer.guess("с");
        assertEquals("с****", new String(game.getGuessedWord()));
    }

    @Test
    public void testGameEndWhenWordIsGuessed() {
        String simulatedInput = "с\nл\nо\nв\nо\n";
        InputStream input = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(input);


        for (char c : "слово".toCharArray()) {
            visualizer.guess(String.valueOf(c));
        }

        assertTrue(visualizer.isGuessed(game.getGuessedWord()));
    }
}
