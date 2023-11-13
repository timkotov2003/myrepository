package edu.hw5.task1;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

class Task1Test {

    @ParameterizedTest
    @MethodSource
    void paramTest(List<String> sessions, String expectedAverageTime) {
        assertThat(Task1.calculateAverageTime(sessions)).isEqualTo(expectedAverageTime);
    }

    private static Stream<Arguments> paramTest() {
        return Stream.of(
            Arguments.of(
                List.of(
                    "2022-03-12, 20:20 - 2022-03-12, 23:50",
                    "2022-04-01, 21:30 - 2022-04-02, 01:20"
                ),
                "3ч 40м"
            ),
            Arguments.of(
                List.of(
                    "2022-03-12, 20:20 - 2022-03-12, 23:50",
                    "2022-04-01, 21:30 - 2022-04-02, 01:20",
                    "2022-05-12, 00:00 - 2022-05-13, 06:00"
                ),
                "12ч 26м"
            ),
            Arguments.of(
                List.of(),
                "0ч 0м"
            )
        );
    }

}
