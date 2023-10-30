package edu.hw3.task4;

import java.util.LinkedHashMap;
import java.util.Map;

public class Task4 {

    private Task4() {
    }

    private static final Map<Integer, String> ROMAN_DIGITS = new LinkedHashMap<>();

    @SuppressWarnings("MagicNumber")
    private static void initializeRomanDigits() {
        ROMAN_DIGITS.put(1000, "M");
        ROMAN_DIGITS.put(900, "CM");
        ROMAN_DIGITS.put(500, "D");
        ROMAN_DIGITS.put(400, "CD");
        ROMAN_DIGITS.put(100, "C");
        ROMAN_DIGITS.put(90, "XC");
        ROMAN_DIGITS.put(50, "L");
        ROMAN_DIGITS.put(40, "XL");
        ROMAN_DIGITS.put(10, "X");
        ROMAN_DIGITS.put(9, "IX");
        ROMAN_DIGITS.put(5, "V");
        ROMAN_DIGITS.put(4, "IV");
        ROMAN_DIGITS.put(1, "I");
    }

    static {
        initializeRomanDigits();
    }

    private static final int MAX_ROMAN_NUMBER = 3999;

    public static String convertToRoman(int inputNum) {
        if (inputNum < 0 || inputNum > MAX_ROMAN_NUMBER) {
            throw new IllegalArgumentException("cannot convert this number to roman, illegal arg == " + inputNum);
        }
        int n = inputNum;
        StringBuilder sb = new StringBuilder();
        for (var romanDigit : ROMAN_DIGITS.keySet()) {
            while (n >= romanDigit) {
                n -= romanDigit;
                sb.append(ROMAN_DIGITS.get(romanDigit));
            }
        }
        return sb.toString();
    }
}
