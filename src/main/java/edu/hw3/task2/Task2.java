package edu.hw3.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Task2 {

    private Task2() {
    }

    public static List<String> clusterize(String input) {
        if (input == null) {
            throw new IllegalArgumentException("input string must not be null");
        }
        List<String> result = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            sb.append(c);
            if (c == '(') {
                stack.push(c);
            } else {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        return result;
    }
}
