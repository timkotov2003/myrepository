package edu.hw3.task3;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task3 {

    private Task3() {
    }

    public static Map<Object, Long> freqDict(List<Object> inputList) {
        return inputList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

}
