package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class Task1Test {

    @Test
    void correctTest() {
        String s = "01:01";

        int sec = Task1.minutesToSeconds(s);

        assertThat(sec).isEqualTo(61);
    }

    @Test
    void correctTestWithBigMinutes() {
        String s = "999:59";

        int sec = Task1.minutesToSeconds(s);

        assertThat(sec).isEqualTo(59999);
    }

    @Test
    void testNullInputString() {
        String s = null;

        int result = Task1.minutesToSeconds(s);

        assertThat(result).isEqualTo(-1);
    }

    @Test
    void incorrectTestWithBigSeconds() {
        String s = "10:60";

        int result = Task1.minutesToSeconds(s);

        assertThat(result).isEqualTo(-1);
    }

    @Test
    void incorrectTestWithLetters() {
        String s = "abc";

        int result = Task1.minutesToSeconds(s);

        assertThat(result).isEqualTo(-1);
    }
}
