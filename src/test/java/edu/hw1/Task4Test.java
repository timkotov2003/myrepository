package edu.hw1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

class Task4Test {

    @ParameterizedTest
    @CsvSource(value = {
        "123456, 214365",
        "hTsii  s aimex dpus rtni.g, This is a mixed up string.",
        "badce, abcde"
    })
    void fixStringTest(String inputString, String expectedResult) {
        String actualResult = Task4.fixString(inputString);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void emptyStringTest() {
        String input = "";

        String result = Task4.fixString(input);

        assertThat(result).isEmpty();
    }

    @Test
    void nullStringTest() {
        String input = null;

        String result = Task4.fixString(input);

        assertThat(result).isNull();
    }
}
