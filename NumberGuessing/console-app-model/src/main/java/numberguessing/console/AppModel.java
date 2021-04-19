package numberguessing.console;

import numberguessing.PositiveIntegerGenerator;

public final class AppModel {
    private static final String NEW_LINE = System.lineSeparator();
    public static final String SELECTION_MESSAGE = "1: Single player game" + NEW_LINE + "2: Multiplayer game" + NEW_LINE + "3: Exit"
            + NEW_LINE + "Enter selection: ";

    private final PositiveIntegerGenerator generator;
    private int answer;

    private boolean completed;
    private boolean gameMode;
    private String output;
    private int tries;

    public AppModel(PositiveIntegerGenerator generator) {
        this.generator = generator;
        completed = false;
        gameMode = false;
        output = SELECTION_MESSAGE;
        tries = 0;
    }

    public boolean isCompleted() {
        return completed;
    }

    public String flushOutput() {
        return output;
    }

    public void processInput(String input) {
        if (gameMode) {
            processSingleGame(input);
        } else {
            processSelectionMode(input);
        }
    }

    private void processSelectionMode(String input) {
        if (input.equals("1")) {
            gameMode = true;
            answer = generator.generateLessThanOrEqualToHundred();
            output = "Single player game" + NEW_LINE + "I'm thinking of a number between 1 and 100."
                    + NEW_LINE + "Enter your guess: ";
        } else if (input.equals("3")) {
            gameMode = false;
            completed = true;
        }
    }

    private void processSingleGame(String input) {
        tries++;
        int guess = Integer.parseInt(input);
        if (answer > guess) {
            output = "Your guess is too low." + NEW_LINE + "Enter your guess: ";
        } else if (answer < guess) {
            output = "Your guess is too high." + NEW_LINE + "Enter your guess: ";
        } else {
            output = "Correct! " + tries + (tries == 1 ? " guess." : " guesses.") + NEW_LINE;
            output += SELECTION_MESSAGE;
            gameMode = false;
        }
    }
}
