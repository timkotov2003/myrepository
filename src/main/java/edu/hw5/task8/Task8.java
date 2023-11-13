package edu.hw5.task8;

public class Task8 {

    private Task8() {
    }

    // нечетной длины
    public static boolean subtask1(String string) {
        return string.matches("^(00|01|10|11)*[01]$");
    }

    // начинается с 0 и имеет нечетную длину, или начинается с 1 и имеет четную длину
    public static boolean subtask2(String string) {
        return string.matches("0([01][01])*|1([01][01])*[01]");
    }

    // количество 0 кратно 3
    public static boolean subtask3(String string) {
        return string.matches("^1*$|^(1*01*01*01*)*$");
    }

    // любая строка, кроме 11 или 111
    public static boolean subtask4(String string) {
        return string.matches("^(?!^111$|^11$)([01]*?)$");
    }

    // каждый нечетный символ равен 1
    public static boolean subtask5(String string) {
        return string.matches("^(1[01])*1{0,1}$");
    }

    // содержит не менее двух 0 и не более одной 1
    public static boolean subtask6(String string) {
        return string.matches("^0{2,}$|^0*(001|010|100)0*$");
    }

    // нет последовательных 1
    public static boolean subtask7(String string) {
        return string.matches("^(10|0)*[01]?$");
    }

}
