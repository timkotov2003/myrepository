package edu.hw1;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

class Task1Test {

    @ParameterizedTest
    @MethodSource
    void paramTest(String input, int expected) {
        int sec = Task1.minutesToSeconds(input);

        assertThat(sec).isEqualTo(expected);
    }

    private static Stream<Arguments> paramTest() {
        return Stream.of(
            Arguments.of("01:01", 61),
            Arguments.of("999:59", 59999),
            Arguments.of(null, -1),
            Arguments.of("10:60", -1),
            Arguments.of("abc", -1),
            Arguments.of("-1:-1", -1)
        );
    }
}
