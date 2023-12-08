package edu.hw5.task4;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

class Task4Test {

    @ParameterizedTest
    @MethodSource
    void paramTest(String validPassword) {
        assertThat(Task4.passwordChecker(validPassword)).isTrue();
    }

    private static Stream<Arguments> paramTest() {
        return Stream.of(
            Arguments.of("text~"),
            Arguments.of("!text"),
            Arguments.of("text#$%text"),
            Arguments.of("#$text%^"),
            Arguments.of("text~text"),
            Arguments.of("text!text"),
            Arguments.of("text@text"),
            Arguments.of("text#text"),
            Arguments.of("text$text"),
            Arguments.of("text%text"),
            Arguments.of("text^text"),
            Arguments.of("text&text"),
            Arguments.of("text*text"),
            Arguments.of("text|text")
        );
    }

    @Test
    void falseTesst() {
        String input = "123 abc";

        boolean result = Task4.passwordChecker(input);

        assertThat(result).isFalse();
    }
}
