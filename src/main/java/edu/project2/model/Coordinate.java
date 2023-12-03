package edu.project2.model;

public record Coordinate(int row, int col) {

    public static Coordinate of(int row, int col) {
        return new Coordinate(row, col);
    }
}
