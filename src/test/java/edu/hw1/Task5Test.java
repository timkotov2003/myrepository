package edu.hw1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThat;

class Task5Test {

    @ParameterizedTest
    @ValueSource(ints = {0, 11, -11, 121, 123312, 11211230, 13001120, 23336014})
    void isPalindromeDescendant(int input) {
        boolean result = Task5.isPalindromeDescendant(input);

        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {122, -122, 123318})
    void isNotPalindromeDescendant(int input) {
        boolean result = Task5.isPalindromeDescendant(input);

        assertThat(result).isFalse();
    }

}
