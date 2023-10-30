package edu.hw3.task1;

public class Task1 {

    public static final char FIRST_LOWERCASE_LETTER = 'a';
    public static final char LAST_LOWERCASE_LETTER = 'z';
    public static final char FIRST_UPPERCASE_LETTER = 'A';
    public static final char LAST_UPPERCASE_LETTER = 'Z';

    private Task1() {
    }

    public static String encryptViaAtbash(String input) {
        if (input == null) {
            throw new IllegalArgumentException("input string must be not null!");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (isLowercaseLetter(currentChar)) {
                sb.append((char) (LAST_LOWERCASE_LETTER - (currentChar - FIRST_LOWERCASE_LETTER)));
            } else if (isUppercaseLetter(currentChar)) {
                sb.append((char) (LAST_UPPERCASE_LETTER - (currentChar - FIRST_UPPERCASE_LETTER)));
            } else {
                sb.append(currentChar);
            }
        }
        return sb.toString();
    }

    private static boolean isUppercaseLetter(char c) {
        return c >= FIRST_UPPERCASE_LETTER && c <= LAST_UPPERCASE_LETTER;
    }

    private static boolean isLowercaseLetter(char c) {
        return c >= FIRST_LOWERCASE_LETTER && c <= LAST_LOWERCASE_LETTER;
    }

}
