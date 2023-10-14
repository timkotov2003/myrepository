package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;

class Task8Test {

    @Test
    void nullExceptionTest() {
        Assertions.assertThatNullPointerException().isThrownBy(() -> Task8.knightBoardCapture(null));
    }

    @ParameterizedTest
    @DisplayName("тесты из описания задачи")
    @ArgumentsSource(ArrayArgumentsProvider.class)
    void tests(int[][] inputArray, boolean expectedResult) {
        boolean actualResult = Task8.knightBoardCapture(inputArray);

        Assertions.assertThat(actualResult).isEqualTo(expectedResult);
    }

    // Очень хотел написать параметризованный тест где несколько аргументов и некоторые из них объекты
    // вот про такую штуку на хабре вычитал https://habr.com/ru/articles/591007/
    // ну и применил, вроде всё работает
    // Но может есть способ проще или лучше? Или этот вариант нормальный?

    static class ArrayArgumentsProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                Arguments.of(
                    new int[][] {
                        {0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 1, 0, 1, 0},
                        {0, 1, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 0, 0, 0, 1},
                        {0, 0, 0, 0, 1, 0, 0, 0}
                    }, true
                ),
                Arguments.of(
                    new int[][] {
                        {1, 0, 1, 0, 1, 0, 1, 0},
                        {0, 1, 0, 1, 0, 1, 0, 1},
                        {0, 0, 0, 0, 1, 0, 1, 0},
                        {0, 0, 1, 0, 0, 1, 0, 1},
                        {1, 0, 0, 0, 1, 0, 1, 0},
                        {0, 0, 0, 0, 0, 1, 0, 1},
                        {1, 0, 0, 0, 1, 0, 1, 0},
                        {0, 0, 0, 1, 0, 1, 0, 1}
                    }, false
                ),
                Arguments.of(
                    new int[][] {
                        {0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 1, 0, 0, 0, 0},
                        {1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 1, 0, 0},
                        {1, 0, 0, 0, 0, 0, 0, 0}
                    }, false
                )
            );
        }
    }
}
