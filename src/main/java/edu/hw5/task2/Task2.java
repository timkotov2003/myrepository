package edu.hw5.task2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("MagicNumber")
public class Task2 {

    private Task2() {
    }

    public static List<LocalDate> getAllFriday13(int year) {
        LocalDate startDate = LocalDate.of(year, 1, 1);
        LocalDate nextFriday13 = getNextFriday13(startDate);
        List<LocalDate> fridays13 = new ArrayList<>();
        while (nextFriday13.getYear() == year) {
            fridays13.add(nextFriday13);
            nextFriday13 = getNextFriday13(nextFriday13);
        }
        return fridays13;
    }

    public static LocalDate getNextFriday13(LocalDate date) {
        LocalDate friday = date.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        while (friday.getDayOfMonth() != 13) {
            friday = friday.plusWeeks(1);
        }
        return friday;
    }

}
