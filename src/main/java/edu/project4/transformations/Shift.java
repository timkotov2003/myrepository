package edu.project4.transformations;

import edu.project4.Point;

public record Shift(double a, double b, double c, double d, double e, double f) implements Transformation {

    @Override
    public Point apply(Point point) {
        double newX = a * point.x() + b * point.y() + c;
        double newY = d * point.x() + e * point.y() + f;
        return new Point(newX, newY);
    }
}
