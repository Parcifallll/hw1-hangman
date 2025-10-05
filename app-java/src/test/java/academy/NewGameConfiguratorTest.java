package academy;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

public class NewGameConfiguratorTest {

    private NewGameConfigurator gameConfigurator;

    @BeforeEach
    public void setUp() {
        gameConfigurator = new NewGameConfigurator(WordList.getDict());
    }

    @Test
    public void testRandomCategorySelection() {
        String simulatedInput = "\n"; // user did not choose any category
        InputStream input = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(input);

        String category = gameConfigurator.getCategory();
        assertNotNull(category);
        assertTrue(List.of("транспорт", "страны", "фрукты", "животные", "спорт").contains(category)
        );
    }

    @Test
    public void testRandomLevelSelection() {
        String simulatedInput = "\n";  // user did not choose any level
        InputStream input = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(input);

        String category = "животные";
        String level = gameConfigurator.getLevel(category);
        assertNotNull(level);
        assertTrue(WordList.getDict().get(category).containsKey(level));
    }

    @Test
    public void testRandomWordSelection() {
        String simulatedInput = "\n";
        InputStream input = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(input);

        String category = "животные";
        String level = "легко";
        String word = gameConfigurator.getRandomWord(category, level);

        assertNotNull(word);
        assertTrue(WordList.getDict().get(category).get(level).contains(word));
    }
}
