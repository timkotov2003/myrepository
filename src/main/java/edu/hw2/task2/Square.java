package edu.hw2.task2;

public class Square extends Rectangle {

    public Square(int side) {
        super(side, side);
    }

    public void setSide(int side) {
        super.setHeight(side);
        super.setWidth(side);
    }

    @Override
    public void setWidth(int side) {
        setSide(side);
    }

    @Override
    public void setHeight(int side) {
        setSide(side);
    }
}
