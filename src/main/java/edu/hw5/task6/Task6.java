package edu.hw5.task6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task6 {

    private Task6() {
    }

    public static boolean hasSubstring(String substring, String string) {
        Pattern pattern = Pattern.compile(substring);
        Matcher matcher = pattern.matcher(string);
        return matcher.find();
    }

}
