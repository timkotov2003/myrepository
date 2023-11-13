package edu.hw5.task5;

import java.util.regex.Pattern;

public class Task5 {

    private Task5() {
    }

    public static boolean check(String number) {
        Pattern pattern = Pattern.compile("^[A-ZА-Я]\\d{3}[A-ZА-Я]{2}\\d{3}$");
        return pattern.matcher(number).find();
    }

}
