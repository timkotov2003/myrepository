package edu.hw3.task4;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Task4Test {

    @ParameterizedTest
    @MethodSource
    void paramTest(int input, String expectedResult) {
        var actualResult = Task4.convertToRoman(input);

        Assertions.assertThat(actualResult).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> paramTest() {
        return Stream.of(
            Arguments.of(2, "II"),
            Arguments.of(12, "XII"),
            Arguments.of(16, "XVI"),
            Arguments.of(3987, "MMMCMLXXXVII"),
            Arguments.of(1234, "MCCXXXIV")
        );
    }
}
