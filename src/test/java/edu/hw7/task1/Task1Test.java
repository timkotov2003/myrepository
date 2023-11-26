package edu.hw7.task1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class Task1Test {

    @Test
    void testCounter() throws InterruptedException {
        Counter counter = new Counter();
        int count = 100_000;

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < count; i++) {
                counter.increment();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < count; i++) {
                counter.increment();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        assertThat(counter.getCount()).isEqualTo(count * 2);
    }
}
