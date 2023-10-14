package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class Task7Test {

    @Test
    void rotateLeft() {
        int n = 17;
        int shift = 2;

        int result = Task7.rotateLeft(n, shift);

        assertThat(result).isEqualTo(6);
    }

    @Test
    void rotateLeftWithBigShift() {
        int n = 17;
        int shift = 172;

        int result = Task7.rotateLeft(n, shift);

        assertThat(result).isEqualTo(6);
    }

    @Test
    void rotateRight() {
        int n = 8;
        int shift = 1;

        int result = Task7.rotateRight(n, shift);

        assertThat(result).isEqualTo(4);
    }

    @Test
    void rotateRightWithBigShift() {
        int n = 8;
        int shift = 201;

        int result = Task7.rotateRight(n, shift);

        assertThat(result).isEqualTo(4);
    }
}
