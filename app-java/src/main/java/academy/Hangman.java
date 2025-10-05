package academy;

public class Hangman {
    private static final String[] HANGMAN = {
        // 0 mistakes
        """
         ------
         |    |
         |
         |
         |
         |
        ---
        """,
        // 1 mistake
        """
         ------
         |    |
         |    O
         |
         |
         |
        ---
        """,
        // 2 mistakes
        """
         ------
         |    |
         |    O
         |    |
         |
         |
        ---
        """,
        // 3 mistakes
        """
         ------
         |    |
         |    O
         |   /|
         |
         |
        ---
        """,
        // 4 - mistakes
        """
         ------
         |    |
         |    O
         |   /|\\
         |
         |
        ---
        """,
        // 5 mistakes
        """
         ------
         |    |
         |    O
         |   /|\\
         |   /
         |
        ---
        """,
        // 6 mistakes
        """
         ------
         |    |
         |    O
         |   /|\\
         |   / \\
         |
        ---
        """
    };


    public void displayHangman(int attemptsLeft) {
        System.out.println(HANGMAN[HANGMAN.length - attemptsLeft - 1]);
    }


}
