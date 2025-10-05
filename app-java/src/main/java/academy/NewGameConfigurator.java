package academy;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class NewGameConfigurator {
    private final Scanner scanner = new Scanner(System.in);
    private final Map<String, Map<String, List<String>>> wordList;

    public NewGameConfigurator(Map<String, Map<String, List<String>>> wordList) {
        this.wordList = wordList;
    }

    public String getCategory() {
        System.out.print("Выберите категорию: ");
        wordList.keySet().forEach(cat -> System.out.print(cat + " "));
        System.out.println();

        String category = scanner.nextLine().trim().toLowerCase();
        while (!category.isEmpty() && !wordList.containsKey(category)) {
            System.out.println("Такой категории нет. Выберите категорию: ");
            category = scanner.nextLine().trim();
            category = category.toLowerCase();
        }

        if (category.isEmpty()) {
            category = RandomPicker.getRandomCategory(wordList);
            System.out.println("Выбрана случайная категория: " + category);
        }

        return category;
    }

    public String getLevel(String category) {
        System.out.print("Выберите сложность: ");
        wordList.get(category).keySet().forEach(level -> System.out.print(level + " "));
        System.out.println();

        String level = scanner.nextLine().trim().toLowerCase();
        while (!level.isEmpty() && !wordList.get(category).containsKey(level)) {
            System.out.println("Такого уровня нет. Выберите уровень: ");
            level = scanner.nextLine().trim();
            level = level.toLowerCase();
        }

        if (level.isEmpty()) {
            level = RandomPicker.getRandomLevel(wordList, category);
            System.out.println("Выбран случайный уровень: " + level);
        }

        return level;
    }

    public String getRandomWord(String category, String level) {
        return RandomPicker.getRandomWord(wordList, category, level);
    }
}
