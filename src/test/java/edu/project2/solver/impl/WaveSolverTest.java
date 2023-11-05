package edu.project2.solver.impl;

import edu.project2.model.Cell;
import edu.project2.model.Coordinate;
import edu.project2.model.Maze;
import edu.project2.renderer.impl.ConsoleRenderer;
import edu.project2.solver.Solver;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class WaveSolverTest {

    @Test
    void test() {
        Maze maze = new Maze(
            7, 5,
            new Cell[][] {
                {Cell.WALL, Cell.WALL, Cell.WALL, Cell.WALL, Cell.WALL},
                {Cell.WALL, Cell.PASSAGE, Cell.PASSAGE, Cell.PASSAGE, Cell.WALL},
                {Cell.WALL, Cell.WALL, Cell.WALL, Cell.PASSAGE, Cell.WALL},
                {Cell.WALL, Cell.PASSAGE, Cell.PASSAGE, Cell.PASSAGE, Cell.WALL},
                {Cell.WALL, Cell.PASSAGE, Cell.WALL, Cell.WALL, Cell.WALL},
                {Cell.WALL, Cell.PASSAGE, Cell.PASSAGE, Cell.PASSAGE, Cell.WALL},
                {Cell.WALL, Cell.WALL, Cell.WALL, Cell.WALL, Cell.WALL},
            }
        );

        Solver solver = new WaveSolver();

        var coordinates = solver.solve(maze, Coordinate.of(1, 1), Coordinate.of(5, 3));

        System.out.println(new ConsoleRenderer().render(maze, coordinates));

        Assertions.assertThat(coordinates).isEqualTo(List.of(
            Coordinate.of(5, 3),
            Coordinate.of(5, 2),
            Coordinate.of(5, 1),
            Coordinate.of(4, 1),
            Coordinate.of(3, 1),
            Coordinate.of(3, 2),
            Coordinate.of(3, 3),
            Coordinate.of(2, 3),
            Coordinate.of(1, 3),
            Coordinate.of(1, 2),
            Coordinate.of(1, 1)
        ));
    }

}
