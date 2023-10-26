package edu.hw2;

import edu.hw2.task1.Addition;
import edu.hw2.task1.Constant;
import edu.hw2.task1.Exponent;
import edu.hw2.task1.Expr;
import edu.hw2.task1.Multiplication;
import edu.hw2.task1.Negate;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {

    @Test
    public void constantTest() {
        double value = 2;

        Expr constant = new Constant(value);

        assertThat(constant.evaluate()).isEqualTo(value);
    }

    @Test
    public void negateTest() {
        Expr constant = new Constant(1);

        Expr negate = new Negate(constant);

        assertThat(negate.evaluate()).isEqualTo(-1);
    }

    @Test
    public void exponentTest() {
        Expr constant = new Constant(5);
        long power = 2;

        Expr exponent = new Exponent(constant, power);

        assertThat(exponent.evaluate()).isEqualTo(25);
    }

    @Test
    public void additionTest() {
        Expr firstArg = new Constant(2);
        Expr secondArg = new Constant(3);

        Expr addition = new Addition(firstArg, secondArg);

        assertThat(addition.evaluate()).isEqualTo(5);
    }

    @Test
    public void multiplicationTest() {
        Expr firstArg = new Constant(2);
        Expr secondArg = new Constant(3);

        Expr multiplication = new Multiplication(firstArg, secondArg);

        assertThat(multiplication.evaluate()).isEqualTo(6);
    }
}
