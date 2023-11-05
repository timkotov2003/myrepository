package edu.project2.renderer.impl;

import edu.project2.model.Cell;
import edu.project2.model.Coordinate;
import edu.project2.model.Maze;
import edu.project2.renderer.Renderer;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class ConsoleRendererTest {

    @Test
    void renderWithoutPath() {
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
        Renderer renderer = new ConsoleRenderer();

        String result = renderer.render(maze);

        String expected = """
            #####
            #   #
            ### #
            #   #
            # ###
            #   #
            #####
            """;

        assertThat(result).isEqualToIgnoringNewLines(expected);
    }

    @Test
    void renderWithPath() {
        Maze maze = new Maze(
            4, 4,
            new Cell[][] {
                {Cell.WALL, Cell.WALL, Cell.WALL, Cell.WALL},
                {Cell.WALL, Cell.PASSAGE, Cell.PASSAGE, Cell.WALL},
                {Cell.WALL, Cell.PASSAGE, Cell.PASSAGE, Cell.WALL},
                {Cell.WALL, Cell.WALL, Cell.WALL, Cell.WALL},
            }
        );
        Renderer renderer = new ConsoleRenderer();

        String result = renderer.render(
            maze,
            List.of(
                Coordinate.of(1, 1),
                Coordinate.of(2, 1),
                Coordinate.of(2, 2)
            )
        );

        String expected = """
            ####
            #∙ #
            #∙∙#
            ####
            """;

        assertThat(result).isEqualToIgnoringNewLines(expected);
    }
}
