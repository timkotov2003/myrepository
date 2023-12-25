package edu.hw7.task4;

import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

class MonteCarloPiCalculatorTest {

    @Test
    void monteCarloSingleTest() throws InterruptedException {
        int dotsCount = 10_000_000;

        double actualPi = MonteCarloPiCalculator.singleThread(dotsCount);

        Assertions.assertThat(actualPi).isCloseTo(Math.PI, Offset.offset(0.01));
    }

    @Test
    void monteCarloMultiTest() throws InterruptedException {
        int dotsCount = 10_000_000;

        double actualPi = MonteCarloPiCalculator.multiThread(dotsCount);

        Assertions.assertThat(actualPi).isCloseTo(Math.PI, Offset.offset(0.01));
    }
}
