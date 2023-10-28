package edu.hw3.task3;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Task3Test {

    @ParameterizedTest
    @MethodSource
    void paramTest(List<Object> input, Map<Object, Long> expectedResult) {
        var actualResult = Task3.freqDict(input);

        Assertions.assertThat(actualResult).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> paramTest() {
        return Stream.of(
            Arguments.of(List.of(), Map.of()),
            Arguments.of(List.of("a", "bb", "a", "bb"), Map.of("bb", 2L, "a", 2L)),
            Arguments.of(List.of("this", "and", "that", "and"), Map.of("that", 1L, "and", 2L, "this", 1L)),
            Arguments.of(List.of("код", "код", "код", "bug"), Map.of("код", 3L, "bug", 1L)),
            Arguments.of(List.of(1, 1, 2, 2), Map.of(1, 2L, 2, 2L))
        );
    }
}
