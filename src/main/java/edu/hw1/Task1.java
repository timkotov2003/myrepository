package edu.hw1;

public class Task1 {

    public static final int SECONDS_IN_MINUTE = 60;

    private Task1() {
    }

    public static int minutesToSeconds(String input) {
        if (input == null) {
            return -1;
        }
        int minuts;
        int seconds;
        try {
            minuts = Integer.parseInt(input.split(":")[0]);
            seconds = Integer.parseInt(input.split(":")[1]);
        } catch (NumberFormatException e) {
            return -1;
        }
        if (seconds >= SECONDS_IN_MINUTE || seconds < 0 || minuts < 0) {
            return -1;
        }
        return minuts * SECONDS_IN_MINUTE + seconds;
    }
}
