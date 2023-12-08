package edu.hw5.task7;

public class Task7 {

    private Task7() {
    }

    private static final String FIRST_REGEX = "^[01]{2}0[01]*$";

    private static final String SECOND_REGEX = "0|1|^0[01]*0$|^1[01]*1$";

    private static final String THIRD_REGEX = "^[01]{1,3}$";

    public static boolean isMoreThanThreeSymbolsThirdIsZero(String string) {
        return string.matches(FIRST_REGEX);
    }

    public static boolean isStartsAndEndsWithSameSymbol(String string) {
        return string.matches(SECOND_REGEX);
    }

    public static boolean isLengthBetweenOneAndThree(String string) {
        return string.matches(THIRD_REGEX);
    }
}
