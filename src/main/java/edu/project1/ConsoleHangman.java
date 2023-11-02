package edu.project1;

import edu.project1.GuessResult.Defeat;
import edu.project1.GuessResult.Win;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ConsoleHangman {

    private static final String END_STRING = "exit";
    private static final int CORRECT_INPUT_LENGTH = 1;
    private final Session session;
    private final PrintStream printStream;
    private final Scanner scanner;

    public ConsoleHangman(Dictionary dictionary, int maxAttempts) {
        this(dictionary, maxAttempts, System.in, System.out);
    }

    public ConsoleHangman(Dictionary dictionary, int maxAttempts, InputStream inputStream, PrintStream printStream) {
        session = new Session(dictionary, maxAttempts);
        this.scanner = new Scanner(inputStream);
        this.printStream = printStream;
    }

    public void run() {
        String input = "";
        GuessResult guessResult;
        while (!END_STRING.equals(input) && scanner.hasNext()) {
            input = scanner.nextLine();
            if (input.length() == CORRECT_INPUT_LENGTH) {
                guessResult = tryGuess(session, input);
                printState(guessResult);
                if (guessResult instanceof Win || guessResult instanceof Defeat) {
                    return;
                }
            }
        }
    }

    private GuessResult tryGuess(Session session, String input) {
        return session.guess(input.charAt(0));
    }

    private void printState(GuessResult guess) {
        printStream.println(guess.message());
        printStream.println(guess.statusWord());
    }
}
