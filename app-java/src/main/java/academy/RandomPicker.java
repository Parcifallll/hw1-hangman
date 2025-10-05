package academy;

import java.util.*;

public class RandomPicker {
    public static String getRandomCategory(Map<String, Map<String, List<String>>> map) {
        List<String> categories = new ArrayList<>(map.keySet());
        Random rand = new Random();
        return categories.get(rand.nextInt(categories.size()));
    }

    public static String getRandomLevel(Map<String, Map<String, List<String>>> map, String category) {
        Map<String, List<String>> levelsMap = map.get(category);
        List<String> levels = new ArrayList<>(levelsMap.keySet());
        Random rand = new Random();
        return levels.get(rand.nextInt(levels.size()));
    }


    public static String getRandomWord(Map<String, Map<String, List<String>>> map, String category, String level) {
        List<String> words = map.get(category).get(level);
        Random rand = new Random();
        return words.get(rand.nextInt(words.size()));
    }
}
