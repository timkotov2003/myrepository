package edu.hw3.task8;

import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class BackwardIteratorTest {

    @Test
    void sampleTest() {
        Iterator<Integer> iterator = new BackwardIterator<>(List.of(1, 2, 3));

        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(3);
        assertThat(iterator.next()).isEqualTo(2);
        assertThat(iterator.next()).isEqualTo(1);
        assertThat(iterator.hasNext()).isFalse();
    }
}
