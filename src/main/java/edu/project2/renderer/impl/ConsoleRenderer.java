package edu.project2.renderer.impl;

import edu.project2.model.Cell;
import edu.project2.model.Coordinate;
import edu.project2.model.Maze;
import edu.project2.renderer.Renderer;
import java.util.Collections;
import java.util.List;

public class ConsoleRenderer implements Renderer {

    private static final String CELL = " ";
    private static final String PATH = "∙";
    private static final String WALL = "#";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Override
    public String render(Maze maze) {
        return render(maze, Collections.emptyList());
    }

    @Override
    public String render(Maze maze, List<Coordinate> path) {
        Cell[][] grid = maze.getGrid();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maze.getHeight(); i++) {
            for (int j = 0; j < maze.getWidth(); j++) {
                if (path.contains(Coordinate.of(i, j))) {
                    sb.append(PATH);
                } else {
                    sb.append(grid[i][j].isWall() ? WALL : CELL);
                }

            }
            sb.append(LINE_SEPARATOR);
        }
        return sb.toString();
    }
}
