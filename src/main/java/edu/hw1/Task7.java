package edu.hw1;

public class Task7 {

    private Task7() {
    }

    public static int rotateLeft(int n, int shift) {
        String inputNumAsString = Integer.toString(n, 2);
        int newShift = shift % inputNumAsString.length();
        String resultString = inputNumAsString.substring(newShift) + inputNumAsString.substring(0, newShift);
        return Integer.parseInt(resultString, 2);
    }

    public static int rotateRight(int n, int shift) {
        String inputNumAsString = Integer.toString(n, 2);
        int newShift = shift % inputNumAsString.length();
        String resultString = inputNumAsString.substring(inputNumAsString.length() - newShift)
            + inputNumAsString.substring(0, inputNumAsString.length() - newShift);
        return Integer.parseInt(resultString, 2);
    }
}
