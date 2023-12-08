package edu.hw5.task7;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class Task7Test {

    @Test
    void firstSubtaskTrue() {
        String input = "010";

        boolean result = Task7.isMoreThanThreeSymbolsThirdIsZero(input);

        assertThat(result).isTrue();
    }

    @Test
    void firstSubtaskFalse() {
        String input = "011";

        boolean result = Task7.isMoreThanThreeSymbolsThirdIsZero(input);

        assertThat(result).isFalse();
    }

    @Test
    void firstSubtaskFalse2() {
        String input = "0111";

        boolean result = Task7.isMoreThanThreeSymbolsThirdIsZero(input);

        assertThat(result).isFalse();
    }

    @Test
    void secondSubtaskTrue() {
        String input = "011010";

        boolean result = Task7.isStartsAndEndsWithSameSymbol(input);

        assertThat(result).isTrue();
    }

    @Test
    void secondSubtaskFalse() {
        String input = "011011";

        boolean result = Task7.isStartsAndEndsWithSameSymbol(input);

        assertThat(result).isFalse();
    }

    @Test
    void thirdSubtaskTrue() {
        String input = "01";

        boolean result = Task7.isLengthBetweenOneAndThree(input);

        assertThat(result).isTrue();
    }

    @Test
    void thirdSubtaskFalse() {
        String input = "0111";

        boolean result = Task7.isLengthBetweenOneAndThree(input);

        assertThat(result).isFalse();
    }
}
