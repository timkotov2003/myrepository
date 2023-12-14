package edu.hw9.task3;

import edu.project2.model.Coordinate;
import edu.project2.model.Maze;
import edu.project2.solver.Solver;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import static java.util.Collections.emptyList;

public class ThreadedWaveSolver implements Solver {

    private static final int MAX_NEIGHBOUR_COUNT = 4;

    public List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end) {

        int[][] distances = new int[maze.getHeight()][maze.getWidth()];
        Queue<Coordinate> queue = new ConcurrentLinkedQueue<>();

        for (int i = 0; i < maze.getHeight(); i++) {
            for (int j = 0; j < maze.getWidth(); j++) {
                distances[i][j] = -1;
            }
        }

        queue.add(start);
        distances[start.row()][start.col()] = 0;

        ExecutorService executor = Executors.newFixedThreadPool(
            MAX_NEIGHBOUR_COUNT
        );

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();

            if (current.equals(end)) {
                break;
            }

            List<Coordinate> neighbors = maze.getNeighbors(current);
            var latch = new CountDownLatch(neighbors.size());

            for (Coordinate neighbor : neighbors) {

                executor.submit(() -> {
                    if (distances[neighbor.row()][neighbor.col()] == -1) {

                        distances[neighbor.row()][neighbor.col()]
                            = distances[current.row()][current.col()] + 1;

                        queue.add(neighbor);
                    }
                    latch.countDown();
                });

            }

            try {
                latch.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        List<Coordinate> path = new ArrayList<>();
        final AtomicReference<Coordinate> current = new AtomicReference<>(end);
        path.add(current.get());

        while (!current.get().equals(start)) {
            List<Coordinate> neighbors = maze.getNeighbors(current.get());

            AtomicInteger cnt = new AtomicInteger(0);
            var latch = new CountDownLatch(neighbors.size());
            var breakLatch = new CountDownLatch(1);

            for (Coordinate neighbor : neighbors) {

                executor.submit(() -> {
                    if (distances[neighbor.row()][neighbor.col()]
                        == distances[current.get().row()][current.get().col()] - 1
                        && breakLatch.getCount() != 0) {

                        breakLatch.countDown();
                        cnt.incrementAndGet();
                        current.set(neighbor);
                        path.add(current.get());
                    }
                    latch.countDown();
                });
            }

            try {
                latch.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (cnt.get() == 0) {
                return emptyList();
            }
        }

        executor.shutdownNow();

        return path;
    }
}
