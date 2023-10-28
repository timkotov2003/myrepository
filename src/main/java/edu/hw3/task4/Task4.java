package edu.hw3.task4;

import java.util.LinkedHashMap;
import java.util.Map;

public class Task4 {

    private Task4() {
    }

    @SuppressWarnings("MagicNumber")
    private static final Map<Integer, String> ROMAN_DIGITS = new LinkedHashMap<>() {
        {
            put(1000, "M");
            put(900, "CM");
            put(500, "D");
            put(400, "CD");
            put(100, "C");
            put(90, "XC");
            put(50, "L");
            put(40, "XL");
            put(10, "X");
            put(9, "IX");
            put(5, "V");
            put(4, "IV");
            put(1, "I");
        }
    };
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
