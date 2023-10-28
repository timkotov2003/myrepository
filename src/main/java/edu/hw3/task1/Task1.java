package edu.hw3.task1;

public class Task1 {

    public static final char FIRST_SMALL_LETTER = 'a';
    public static final char LAST_SMALL_LETTER = 'z';
    public static final char FIRST_BIG_LETTER = 'A';
    public static final char LAST_BIG_LETTER = 'Z';

    private Task1() {
    }

    public static String atbash(String input) {
        if (input == null) {
            throw new IllegalArgumentException("input string must be not null!");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (isSmallLetter(currentChar)) {
                sb.append((char) (LAST_SMALL_LETTER - (currentChar - FIRST_SMALL_LETTER)));
            } else if (isBigLetter(currentChar)) {
                sb.append((char) (LAST_BIG_LETTER - (currentChar - FIRST_BIG_LETTER)));
            } else {
                sb.append(currentChar);
            }
        }
        return sb.toString();
    }

    private static boolean isBigLetter(char c) {
        return c >= FIRST_BIG_LETTER && c <= LAST_BIG_LETTER;
    }

    private static boolean isSmallLetter(char c) {
        return c >= FIRST_SMALL_LETTER && c <= LAST_SMALL_LETTER;
    }

}
