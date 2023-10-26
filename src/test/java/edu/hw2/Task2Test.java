package edu.hw2;

import edu.hw2.task2.Rectangle;
import edu.hw2.task2.Square;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {

    @Test
    void rectangleTest() {
        int width = 20;
        int height = 10;

        Rectangle rectangle = new Rectangle(width, height);

        assertThat(rectangle.area()).isEqualTo(200);

        rectangle.setWidth(2);
        rectangle.setHeight(3);

        assertThat(rectangle.area()).isEqualTo(6);
    }

    @Test
    void createSquareTest() {
        int side = 20;

        Rectangle square = new Square(side);

        assertThat(square.area()).isEqualTo(400);
    }

    @Test
    void settersSquareTest() {
        int side = 20;

        Rectangle square = new Square(side);
        square.setHeight(10);
        square.setWidth(5);

        assertThat(square.area()).isEqualTo(25);
    }

    @Test
    void setSideSquareTest() {
        int side = 20;

        Square square = new Square(side);
        square.setSide(10);

        assertThat(square.area()).isEqualTo(100);
    }

}
