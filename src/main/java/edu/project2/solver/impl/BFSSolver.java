package edu.project2.solver.impl;

import edu.project2.model.Coordinate;
import edu.project2.model.Maze;
import edu.project2.solver.Solver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BFSSolver implements Solver {

    @Override
    public List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end) {
        List<Coordinate> path = new ArrayList<>();
        Queue<Coordinate> queue = new LinkedList<>();
        Map<Coordinate, Coordinate> parentMap = new HashMap<>();

        queue.add(start);
        parentMap.put(start, null);

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();
            if (current.equals(end)) {
                return buildPath(path, parentMap, current);
            }
            for (Coordinate neighbor : maze.getNeighbors(current)) {
                if (!parentMap.containsKey(neighbor)) {
                    queue.add(neighbor);
                    parentMap.put(neighbor, current);
                }
            }
        }
        return path;
    }

    private List<Coordinate> buildPath(
        List<Coordinate> path,
        Map<Coordinate, Coordinate> parentMap,
        Coordinate current
    ) {

        Coordinate newCurrent = current;
        while (newCurrent != null) {
            path.add(newCurrent);
            newCurrent = parentMap.get(newCurrent);
        }
        return path;
    }
}
