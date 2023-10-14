package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class Task3Test {

    @Test
    void nullArrayTest() {
        int[] firstArray = null;
        int[] secondArray = {1};

        boolean result = Task3.isNestable(firstArray, secondArray);

        Assertions.assertThat(result).isFalse();
    }

    @Test
    void emptyFirstArray() {
        int[] firstArray = {};
        int[] secondArray = {1};

        boolean result = Task3.isNestable(firstArray, secondArray);

        Assertions.assertThat(result).isTrue();
    }

    @Test
    void emptySecondArray() {
        int[] firstArray = {1};
        int[] secondArray = {};

        boolean result = Task3.isNestable(firstArray, secondArray);

        Assertions.assertThat(result).isFalse();
    }

    @Test
    void isNested() {
        int[] firstArray = {1, 2, 3, 4};
        int[] secondArray = {0, 6};

        boolean result = Task3.isNestable(firstArray, secondArray);

        Assertions.assertThat(result).isTrue();
    }

    @Test
    void isNotNested() {
        int[] firstArray = {1, 2, 3, 4};
        int[] secondArray = {2, 6};

        boolean result = Task3.isNestable(firstArray, secondArray);

        Assertions.assertThat(result).isFalse();
    }

}
