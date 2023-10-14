package edu.hw1;

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
        int minElementFirstArray = Integer.MAX_VALUE;
        int minElementSecondArray = Integer.MAX_VALUE;
        int maxElementFirstArray = Integer.MIN_VALUE;
        int maxElementSecondArray = Integer.MIN_VALUE;
        for (int element : firstArray) {
            if (element < minElementFirstArray) {
                minElementFirstArray = element;
            }
            if (element > maxElementFirstArray) {
                maxElementFirstArray = element;
            }
        }
        for (int element : secondArray) {
            if (element < minElementSecondArray) {
                minElementSecondArray = element;
            }
            if (element > maxElementSecondArray) {
                maxElementSecondArray = element;
            }
        }
        return minElementFirstArray > minElementSecondArray && maxElementFirstArray < maxElementSecondArray;
    }
}
