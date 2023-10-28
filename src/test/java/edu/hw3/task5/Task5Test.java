package edu.hw3.task5;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Task5Test {

    @ParameterizedTest
    @MethodSource
    void paramTest(String[] people, SortType sortType, Contact[] expectedResult) {
        var actualResult = Task5.parseContacts(people, sortType);

        Assertions.assertThat(actualResult).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> paramTest() {
        return Stream.of(
            Arguments.of(
                new String[] {"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"},
                "ASC",
                new Contact[] {
                    new Contact("Thomas", "Aquinas"),
                    new Contact("Rene", "Descartes"),
                    new Contact("David", "Hume"),
                    new Contact("John", "Locke")
                }
            ),
            Arguments.of(
                new String[] {"John Locke", "Thomas Aquinas", "Htest", "Rene Descartes"},
                "ASC",
                new Contact[] {
                    new Contact("Thomas", "Aquinas"),
                    new Contact("Rene", "Descartes"),
                    new Contact("Htest", null),
                    new Contact("John", "Locke")
                }
            ),
            Arguments.of(
                new String[] {"Paul Erdos", "Leonhard Euler", "Carl Gauss"},
                "DESC",
                new Contact[] {new Contact("Carl", "Gauss"),
                    new Contact("Leonhard", "Euler"),
                    new Contact("Paul", "Erdos")}
            ),
            Arguments.of(new String[] {}, "DESC", new Contact[0]),
            Arguments.of(null, "DESC", new Contact[0])
        );
    }

}
