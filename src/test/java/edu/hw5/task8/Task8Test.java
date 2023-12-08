package edu.hw5.task8;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class Task8Test {

    @Test
    void subtask1True() {
        String input = "010";

        boolean result = Task8.subtask1(input);

        Assertions.assertThat(result).isTrue();
    }

    @Test
    void subtask1False() {
        String input = "0101";

        boolean result = Task8.subtask1(input);

        Assertions.assertThat(result).isFalse();
    }

    @Test
    void subtask2True() {
        String input = "01111";

        boolean result = Task8.subtask2(input);

        Assertions.assertThat(result).isTrue();
    }

    @Test
    void subtask2False() {
        String input = "10000";

        boolean result = Task8.subtask2(input);

        Assertions.assertThat(result).isFalse();
    }

    @Test
    void subtask3True() {
        String input = "0000110101";

        boolean result = Task8.subtask3(input);

        Assertions.assertThat(result).isTrue();
    }

    @Test
    void subtask3False() {
        String input = "01010101";

        boolean result = Task8.subtask3(input);

        Assertions.assertThat(result).isFalse();
    }

    @Test
    void subtask4True() {
        String input = "1111";

        boolean result = Task8.subtask4(input);

        Assertions.assertThat(result).isTrue();
    }

    @Test
    void subtask4False() {
        String input = "111";

        boolean result = Task8.subtask4(input);

        Assertions.assertThat(result).isFalse();
    }

    @Test
    void subtask5True() {
        String input = "11101";

        boolean result = Task8.subtask5(input);

        Assertions.assertThat(result).isTrue();
    }

    @Test
    void subtask5False() {
        String input = "01111";

        boolean result = Task8.subtask5(input);

        Assertions.assertThat(result).isFalse();
    }

    @Test
    void subtask6True() {
        String input = "0100";

        boolean result = Task8.subtask6(input);

        Assertions.assertThat(result).isTrue();
    }

    @Test
    void subtask6False() {
        String input = "0010010";

        boolean result = Task8.subtask6(input);

        Assertions.assertThat(result).isFalse();
    }

    @Test
    void subtask7True() {
        String input = "100010101";

        boolean result = Task8.subtask7(input);

        Assertions.assertThat(result).isTrue();
    }

    @Test
    void subtask7False() {
        String input = "10001100101";

        boolean result = Task8.subtask7(input);

        Assertions.assertThat(result).isFalse();
    }
}
