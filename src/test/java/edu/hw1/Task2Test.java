package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Task2Test {

    @ParameterizedTest
    @CsvSource(value = {
        "0, 0",
        "12345, 5",
        "-123, 3"
    })
    void countDigitsTest(int inputNumber, int expectedResult) {
        // тут я решил попробовать параметризованный тест, given из source

        int actualResult = Task2.countDigits(inputNumber);

        Assertions.assertThat(actualResult).isEqualTo(expectedResult);
    }
}
