package edu.hw5.task4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task4 {

    private Task4() {
    }

    public static boolean passwordChecker(String password) {
        Pattern pattern = Pattern.compile("[~!@#$%^&*|]");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

}
