package academy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    @Test
    public void startNonInteractiveTest() {
        Game game = new Game("волокно", "толокно");
        assertEquals("*олокно;NEG", game.startNonInteractive());
    }

}
