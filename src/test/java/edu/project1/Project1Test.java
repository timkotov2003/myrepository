package edu.project1;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Project1Test {

    private static Dictionary dictionary;
    private static InputStream inputStream;
    private static ByteArrayOutputStream outputStream;
    private static PrintStream printStream;

    @BeforeAll
    static void initTestDictionary() {
        dictionary = new Dictionary() {
            @Override
            public String randomWord() {
                return "test";
            }
        };
    }

    @BeforeEach
    void initOutputStream() {
        outputStream = new ByteArrayOutputStream();
        printStream = new PrintStream(outputStream, true, StandardCharsets.UTF_8);
    }

    @AfterEach
    void closeOutputStream() {
        printStream.close();
    }

    @Test
    void runGameAndWin() {
        String input = """
            a
            t
            e
            a
            s
            """;
        String expectedOutput = """
            Missed, mistake 1 out of 5.
            ****
            Hit!
            t**t
            Hit!
            te*t
            Missed, mistake 2 out of 5.
            te*t
            You won!
            test
            """;
        inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));

        ConsoleHangman game = new ConsoleHangman(dictionary, 5, inputStream, printStream);
        game.run();

        assertThat(outputStream.toString(StandardCharsets.UTF_8)).isEqualToIgnoringWhitespace(expectedOutput);
    }

    @Test
    void runGameAndLost() {
        String input = """
            a
            t
            e
            a
            b
            c
            d
            """;
        String expectedOutput = """
            Missed, mistake 1 out of 5.
            ****
            Hit!
            t**t
            Hit!
            te*t
            Missed, mistake 2 out of 5.
            te*t
            Missed, mistake 3 out of 5.
            te*t
            Missed, mistake 4 out of 5.
            te*t
            You lost!
            te*t
            """;
        inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));

        ConsoleHangman game = new ConsoleHangman(dictionary, 5, inputStream, printStream);
        game.run();

        assertThat(outputStream.toString(StandardCharsets.UTF_8)).isEqualToIgnoringWhitespace(expectedOutput);
    }

    @Test
    void runGameAndExit() {
        String input = """
            a
            t
            exit
            e
            a
            b
            c
            d
            """;
        String expectedOutput = """
            Missed, mistake 1 out of 5.
            ****
            Hit!
            t**t
            """;
        inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));

        ConsoleHangman game = new ConsoleHangman(dictionary, 5, inputStream, printStream);
        game.run();

        assertThat(outputStream.toString(StandardCharsets.UTF_8)).isEqualToIgnoringWhitespace(expectedOutput);
    }
}
