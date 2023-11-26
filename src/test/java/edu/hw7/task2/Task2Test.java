package edu.hw7.task2;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class Task2Test {

    @Test
    void factorialTest() {
        int n = 10;

        long factorial = Factorial.count(n);

        assertThat(factorial).isEqualTo(3628800L);
    }
}
