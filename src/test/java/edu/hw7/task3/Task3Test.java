package edu.hw7.task3;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

class Task3Test {

    @ParameterizedTest
    @MethodSource
    void personDataBaseImplTest(PersonDatabase pd) throws InterruptedException {
        Person person1 = new Person(1, "name1", "address1", "phone1");
        Person person2 = new Person(2, "name2", "address2", "phone2");
        Person person3 = new Person(3, "name3", "address3", "phone3");

        Thread thread1 = new Thread(() -> {
            pd.add(person1);
            pd.add(person2);
            pd.delete(1);
        });
        Thread thread2 = new Thread(() -> {
            pd.add(person3);
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        assertThat(pd.findByName("name1")).isNull();
        assertThat(pd.findByPhone("phone2")).isEqualTo(List.of(person2));
        assertThat(pd.findByAddress("address3")).isEqualTo(List.of(person3));
    }

    private static Stream<Arguments> personDataBaseImplTest() {
        return Stream.of(
            Arguments.of(new SynchronizedPDImpl()),
            Arguments.of(new ReadWriteLockPDImpl())
        );
    }
}
