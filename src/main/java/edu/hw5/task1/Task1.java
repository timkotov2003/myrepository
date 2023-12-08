package edu.hw5.task1;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Task1 {

    private Task1() {
    }

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm");

    public static String calculateAverageTime(List<String> sessions) {
        Duration totalTime = Duration.ZERO;
        Duration duration;
        String[] times;

        for (String session : sessions) {
            times = session.split(" - ");
            duration = Duration.between(
                LocalDateTime.parse(times[0], DATE_TIME_FORMATTER),
                LocalDateTime.parse(times[1], DATE_TIME_FORMATTER)
            );
            totalTime = totalTime.plusSeconds(duration.getSeconds());
        }

        if (sessions.isEmpty()) {
            return "0ч 0м";
        }
        Duration averageTime = totalTime.dividedBy(sessions.size());

        return String.format("%dч %dм", averageTime.toHours(), averageTime.toMinutesPart());
    }
}
