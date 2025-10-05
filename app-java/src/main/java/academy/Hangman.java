package academy;

public class Hangman {
    private int wrongAttempts;
    private final int maxAttempts;
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

    public Hangman(int maxAttempts) {
        this.maxAttempts = maxAttempts;
        this.wrongAttempts = 0;
    }

    public void wrongGuess() {
        wrongAttempts++;
    }

    public int getAttemptsLeft(){
        return maxAttempts - wrongAttempts;
    }

    public void displayHangman() {
        System.out.println(HANGMAN[wrongAttempts]);
    }

    public boolean isGameOver() { // loss
        return wrongAttempts >= maxAttempts;
    }
}
