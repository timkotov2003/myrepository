package edu.hw3.task1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class Task1Test {

    @Test
    void test1() {
        String input = "Hello world!";
        String expectedResult = "Svool dliow!";

        String actualResult = Task1.encryptViaAtbash(input);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void test2() {
        String input =
            "Any fool can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler";
        String expectedResult =
            "Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi";

        String actualResult = Task1.encryptViaAtbash(input);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void testIllegalArgument() {
        String input = null;

        assertThatThrownBy(() -> Task1.encryptViaAtbash(input)).isInstanceOf(IllegalArgumentException.class);
    }
}
