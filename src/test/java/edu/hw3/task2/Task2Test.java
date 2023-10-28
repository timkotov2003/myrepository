package edu.hw3.task2;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Task2Test {

    @ParameterizedTest
    @MethodSource
    void paramTest(String input, List<String> expectedResult) {
        var actualResult = Task2.clusterize(input);

        Assertions.assertThat(actualResult).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> paramTest() {
        return Stream.of(
            Arguments.of("()()()", List.of("()", "()", "()")),
            Arguments.of("((()))", List.of("((()))")),
            Arguments.of("((()))(())()()(()())", List.of("((()))", "(())", "()", "()", "(()())")),
            Arguments.of("((())())(()(()()))", List.of("((())())", "(()(()()))"))
        );
    }
}
