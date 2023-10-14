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

        // вот тут далее длинная строка кода, чекстайл ругался, что много символов, у него ограничение
        // не помещается в одну строку, пришлось разбить её на 2 перед знаком "+"
        // а как вообще в таких случаях стоит поступать? Есть правила как разбивать код и переносить строки?
        // интересует например место где сделать перенос и какие отступы выбрать для строк ниже основной

        String resultString = inputNumAsString.substring(inputNumAsString.length() - newShift)
            + inputNumAsString.substring(0, inputNumAsString.length() - newShift);
        return Integer.parseInt(resultString, 2);
    }
}
