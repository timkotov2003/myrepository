package edu.project1;

import edu.project1.GuessResult.Defeat;
import edu.project1.GuessResult.FailedGuess;
import edu.project1.GuessResult.SuccessfulGuess;
import edu.project1.GuessResult.Win;
import java.util.Arrays;

public class Session {

    private static final char INVISIBLE_CHAR = '*';
    private final String answer;
    private final char[] userAnswer;
    private final int maxAttempts;
    private int attempts;
    private final Dictionary dictionary;

    public Session(Dictionary dictionary, int maxAttempts) {
        this.dictionary = dictionary;
        this.maxAttempts = maxAttempts;
        answer = dictionary.randomWord();
        userAnswer = new char[answer.length()];
        Arrays.fill(userAnswer, INVISIBLE_CHAR);
    }

    public GuessResult guess(char guess) {
        if (guess < 'a' || guess > 'z') {
            throw new IllegalArgumentException("guess only from a to z");
        }
        if (answer.indexOf(guess) != -1) {
            for (int i = 0; i < answer.length(); i++) {
                if (answer.charAt(i) == guess) {
                    userAnswer[i] = guess;
                }
            }
            if (isAnswerFullGuess()) {
                return new Win(userAnswer, attempts, maxAttempts);
            }
            if (attempts == maxAttempts) {
                return new Defeat(userAnswer, attempts, maxAttempts);
            }
            return new SuccessfulGuess(userAnswer, attempts, maxAttempts);
        } else {
            attempts++;
            return attempts == maxAttempts
                ? new Defeat(userAnswer, attempts, maxAttempts)
                : new FailedGuess(userAnswer, attempts, maxAttempts);
        }
    }

    private boolean isAnswerFullGuess() {
        return String.valueOf(userAnswer).equals(answer);
    }
}
