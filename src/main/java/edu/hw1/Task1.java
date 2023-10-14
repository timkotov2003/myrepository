package edu.hw1;

public class Task1 {

    public static final int SECONDS = 60;

    private Task1() {
    }

    public static int minutesToSeconds(String input) {
        int minuts;
        int seconds;
        if (input == null) {
            return -1;
        }
        try {
            minuts = Integer.parseInt(input.split(":")[0]);
            seconds = Integer.parseInt(input.split(":")[1]);
        } catch (NumberFormatException e) {
            return -1;
        }
        if (seconds >= SECONDS) {
            return -1;
        }
        return minuts * SECONDS + seconds;
    }
}
