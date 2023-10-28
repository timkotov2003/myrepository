package edu.hw3.task7;

import java.util.Map;
import java.util.TreeMap;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class TreeMapComparatorTest {

    @Test
    void containsNullKeyTest() {
        Map<String, String> map = new TreeMap<>(new TreeMapComparator<>());

        map.put(null, "test");

        Assertions.assertThat(map.containsKey(null)).isTrue();
    }
}
