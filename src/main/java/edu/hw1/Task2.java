package edu.hw1;

public class Task2 {

    private Task2() {
    }

    @SuppressWarnings("MagicNumber")
    public static int countDigits(int number) {
        int count = 0;
        int input = Math.abs(number);
        while (input > 0) {
            input /= 10;
            count++;
        }
        return count;
    }
}
