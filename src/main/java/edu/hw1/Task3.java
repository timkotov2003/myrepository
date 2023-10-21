package edu.hw1;

import java.util.Arrays;

public class Task3 {

    private Task3() {
    }

    public static boolean isNestable(int[] firstArray, int[] secondArray) {
        if (firstArray == null || secondArray == null) {
            return false;
        }
        if (firstArray.length == 0) {
            return true;
        } else if (secondArray.length == 0) {
            return false;
        }
        int minElementFirstArray = Arrays.stream(firstArray).min().getAsInt();
        int minElementSecondArray = Arrays.stream(secondArray).min().getAsInt();
        int maxElementFirstArray = Arrays.stream(firstArray).max().getAsInt();
        int maxElementSecondArray = Arrays.stream(secondArray).max().getAsInt();
        return minElementFirstArray > minElementSecondArray && maxElementFirstArray < maxElementSecondArray;
    }
}
