package edu.hw9;

import edu.hw9.task3.ThreadedWaveSolver;
import edu.project2.model.Cell;
import edu.project2.model.Coordinate;
import edu.project2.model.Maze;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task3Test {

    @Test
    public void testSolver() {

        Maze maze = new Maze(
            5,
            5,
            new Cell[][] {
                {Cell.WALL, Cell.WALL, Cell.WALL, Cell.WALL, Cell.WALL},
                {Cell.WALL, Cell.PASSAGE, Cell.PASSAGE, Cell.WALL, Cell.WALL},
                {Cell.WALL, Cell.WALL, Cell.PASSAGE, Cell.WALL, Cell.WALL},
                {Cell.WALL, Cell.WALL, Cell.PASSAGE, Cell.PASSAGE, Cell.WALL},
                {Cell.WALL, Cell.WALL, Cell.WALL, Cell.WALL, Cell.WALL}
            }
        );

        List<Coordinate> expectedPath = List.of(
            new Coordinate(3, 3),
            new Coordinate(3, 2),
            new Coordinate(2, 2),
            new Coordinate(1, 2),
            new Coordinate(1, 1)
        );

        List<Coordinate> path = new ThreadedWaveSolver()
            .solve(
                maze,
                new Coordinate(1, 1),
                new Coordinate(3, 3)
            );

        assertEquals(expectedPath, path);
    }

}
