package edu.hw1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class Task6Test {

    @ParameterizedTest
    @CsvSource(value = {
        "6621, 5",
        "6554, 4",
        "1234, 3",
        "-1234, 3"
    })
    void countTest(int inputNum, int expectedResult) {
        int actualResult = Task6.countK(inputNum);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void kaprekarConstTest() {
        int input = Task6.KAPREKAR_CONST;

        int result = Task6.countK(input);

        assertThat(result).isZero();
    }

    @Test
    void illegalArgumentTest() {
        int input = 5555;

        assertThatIllegalArgumentException().isThrownBy(() -> Task6.countK(input));
    }

    @Test
    void illegalArgumentTestWithBigInput() {
        int input = 1234567;

        assertThatIllegalArgumentException().isThrownBy(() -> Task6.countK(input));
    }

    @Test
    void illegalArgumentTestWithSmallInput() {
        int input = 123;

        assertThatIllegalArgumentException().isThrownBy(() -> Task6.countK(input));
    }
}
