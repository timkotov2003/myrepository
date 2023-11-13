package edu.hw5.task6;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class Task6Test {

    @Test
    void trueTest() {
        String s = "achfdbaabgabcaabg";
        String subs = "abc";

        boolean result = Task6.hasSubstring(subs, s);

        assertThat(result).isTrue();
    }

    @Test
    void falseTest() {
        String s = "achfdbaabgabaabg";
        String subs = "abc";

        boolean result = Task6.hasSubstring(subs, s);

        assertThat(result).isFalse();
    }
}
