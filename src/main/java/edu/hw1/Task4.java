package edu.hw1;

public class Task4 {

    private Task4() {
    }

    public static String fixString(String brokenString) {
        if (brokenString == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < brokenString.length(); i++) {
            if (i % 2 == 1) {
                sb.append(brokenString.charAt(i));
                sb.append(brokenString.charAt(i - 1));
            }
        }
        return brokenString.length() % 2 == 0
            ? sb.toString()
            : sb.toString() + brokenString.charAt(brokenString.length() - 1);
    }
}
