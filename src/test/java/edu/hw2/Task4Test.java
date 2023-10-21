package edu.hw2;

import edu.hw2.task4.CallingInfo;
import edu.hw2.task4.Task4;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task4Test {

    @Test
    void callInfoTest() {
        CallingInfo info = Task4.callingInfo();

        Assertions.assertThat(info.className()).isEqualTo("edu.hw2.Task4Test");
        Assertions.assertThat(info.methodName()).isEqualTo("callInfoTest");
    }
}
