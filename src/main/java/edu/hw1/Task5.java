package edu.hw1;

public class Task5 {

    private Task5() {
    }

    public static boolean isPalindromeDescendant(int num) {
        String stringFromInputNum = Integer.toString(Math.abs(num));
        if (stringFromInputNum.contentEquals(new StringBuilder(stringFromInputNum).reverse())) {
            return true;
        }
        if (stringFromInputNum.length() >= 2 && stringFromInputNum.length() % 2 == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < stringFromInputNum.length() / 2; i++) {
                sb.append(stringFromInputNum.charAt(i * 2) - '0' + stringFromInputNum.charAt(i * 2 + 1) - '0');
            }
            return isPalindromeDescendant(Integer.parseInt(sb.toString()));
        } else {
            return false;
        }
    }
}
