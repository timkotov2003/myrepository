package edu.hw1;

public class Task5 {

    private Task5() {
    }

    public static boolean isPalindromeDescendant(int num) {
        String s = Integer.toString(Math.abs(num));
        if (s.contentEquals(new StringBuilder(s).reverse())) {
            return true;
        }
        if (s.length() >= 2 && s.length() % 2 == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length() / 2; i++) {
                sb.append(s.charAt(i * 2) - '0' + s.charAt(i * 2 + 1) - '0');
            }
            return isPalindromeDescendant(Integer.parseInt(sb.toString()));
        } else {
            return false;
        }
    }
}
