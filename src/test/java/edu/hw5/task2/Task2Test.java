package edu.hw5.task2;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

class Task2Test {

    @Test
    void testFindNextFriday13() {
        LocalDate date = LocalDate.of(1925, 2, 20);

        var nextFriday13 = Task2.getNextFriday13(date);

        assertThat(nextFriday13).isEqualTo(LocalDate.of(1925, 3, 13));
    }

    @ParameterizedTest
    @MethodSource
    void testFindFridays13(int year, List<LocalDate> dates) {
        assertThat(Task2.getAllFriday13(year)).isEqualTo(dates);
    }

    static Stream<Arguments> testFindFridays13() {
        return Stream.of(
            Arguments.of(
                1925,
                List.of(
                    LocalDate.of(1925, 2, 13),
                    LocalDate.of(1925, 3, 13),
                    LocalDate.of(1925, 11, 13)
                )
            ),
            Arguments.of(
                2024,
                List.of(
                    LocalDate.of(2024, 9, 13),
                    LocalDate.of(2024, 12, 13)
                )
            )
        );
    }

}
