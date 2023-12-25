package edu.hw7.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class MonteCarloPiCalculator {

    private static final double RADIUS = 1;
    private static final int MONTE_CARLO_CONST = 4;

    private MonteCarloPiCalculator() {
    }

    public static double singleThread(int totalDots) throws InterruptedException {
        return multiThread(totalDots, 1);
    }

    public static double multiThread(int totalDots, int threadCount) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        AtomicInteger totalCircleCount = new AtomicInteger(0);
        for (int i = 0; i < threadCount; i++) {
            threads.add(new Thread(() -> {
                int circleCountByCurrentThread = calc(totalDots / threadCount);
                totalCircleCount.addAndGet(circleCountByCurrentThread);
            }));
            threads.getLast().start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        return (double) MONTE_CARLO_CONST * totalCircleCount.get() / totalDots;
    }

    public static double multiThread(int totalDots) throws InterruptedException {
        return multiThread(totalDots, Runtime.getRuntime().availableProcessors());
    }

    private static int calc(int dotsCount) {
        Random random = ThreadLocalRandom.current();
        int circleCount = 0;
        for (int i = 0; i < dotsCount; i++) {
            double x = random.nextDouble();
            double y = random.nextDouble();
            if (x * x + y * y < RADIUS) {
                circleCount++;
            }
        }
        return circleCount;
    }

}
