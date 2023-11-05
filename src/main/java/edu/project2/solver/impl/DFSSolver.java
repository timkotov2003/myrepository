package edu.project2.solver.impl;

import edu.project2.model.Coordinate;
import edu.project2.model.Maze;
import edu.project2.solver.Solver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DFSSolver implements Solver {

    @Override
    public List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end) {

        List<Coordinate> visited = new ArrayList<>();
        visited.add(start);

        List<Coordinate> path = dfs(maze, start, end, visited);
        return path == null ? Collections.emptyList() : path;
    }

    private List<Coordinate> dfs(
        Maze maze,
        Coordinate current,
        Coordinate end,
        List<Coordinate> visited
    ) {

        if (current.equals(end)) {
            List<Coordinate> path = new ArrayList<>();
            path.add(current);
            return path;
        }

        for (Coordinate neighbor : maze.getNeighbors(current)) {
            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                List<Coordinate> path = dfs(maze, neighbor, end, visited);
                if (path != null) {
                    path.add(current);
                    return path;
                }
            }
        }
        return null;
    }
}
