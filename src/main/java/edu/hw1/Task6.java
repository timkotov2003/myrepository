package edu.hw1;

import java.util.stream.Collectors;

public class Task6 {

    public static final int KAPREKAR_CONST = 6174;

    private Task6() {
    }

    public static int countK(int num) {
        if (Math.abs(num) == KAPREKAR_CONST) {
            return 0;
        }
        String minNumInString = Integer.toString(Math.abs(num)).chars()
            .sorted()
            .mapToObj(Character::toString)
            .collect(Collectors.joining());

        // add leading zeros if num < 1000
        minNumInString = String.format("%04d", Integer.parseInt(minNumInString));

        int min = Integer.parseInt(minNumInString);
        int max = Integer.parseInt(new StringBuilder(minNumInString).reverse().toString());
        if (min == max) {
            throw new IllegalArgumentException("infinity!");
        }
        return countK(max - min) + 1;
    }

}
