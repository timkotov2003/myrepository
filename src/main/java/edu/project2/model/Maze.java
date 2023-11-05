package edu.project2.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Maze {

    private final int height;
    private final int width;
    private final Cell[][] grid;

    public List<Coordinate> getNeighbors(Coordinate coordinate) {
        int row = coordinate.row();
        int col = coordinate.col();
        List<Coordinate> neighbors = new ArrayList<>();

        if (isValidCoordinate(row - 1, col)) {
            neighbors.add(Coordinate.of(row - 1, col));
        }
        if (isValidCoordinate(row + 1, col)) {
            neighbors.add(Coordinate.of(row + 1, col));
        }
        if (isValidCoordinate(row, col - 1)) {
            neighbors.add(Coordinate.of(row, col - 1));
        }
        if (isValidCoordinate(row, col + 1)) {
            neighbors.add(Coordinate.of(row, col + 1));
        }

        return neighbors;
    }

    private boolean isValidCoordinate(int row, int col) {
        return row >= 0 && row < height && col >= 0 && col < width && grid[row][col].isPassage();
    }

}
