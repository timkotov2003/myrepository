package edu.hw1;

public class Task5 {

    public static final char ZERO_CODE = '0';

    private Task5() {
    }

    public static boolean isPalindromeDescendant(int num) {
        return isPalindromeDescendant(Integer.toString(Math.abs(num)));
    }

    private static boolean isPalindromeDescendant(String numAsString) {
        if (numAsString.contentEquals(new StringBuilder(numAsString).reverse())) {
            return true;
        }
        if (numAsString.length() >= 2 && numAsString.length() % 2 == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < numAsString.length() / 2; i++) {
                sb.append(
                    numAsString.charAt(i * 2) - ZERO_CODE + numAsString.charAt(i * 2 + 1) - ZERO_CODE);
            }
            return isPalindromeDescendant(sb.toString());
        }
        return false;
    }
}
