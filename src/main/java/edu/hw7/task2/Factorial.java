package edu.hw7.task2;

import java.util.stream.LongStream;

public class Factorial {

    private Factorial() {
    }

    public static long count(int n) {
        return LongStream.rangeClosed(1, n)
            .parallel()
            .reduce(1, (a, b) -> a * b);
    }
}
