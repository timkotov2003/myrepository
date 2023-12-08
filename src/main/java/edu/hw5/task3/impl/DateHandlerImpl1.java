package edu.hw5.task3.impl;

import edu.hw5.task3.BaseDateHandler;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("MagicNumber")
public class DateHandlerImpl1 extends BaseDateHandler {

    private static final Pattern DATE_PATTERN = Pattern.compile("^(\\d+)-([1-9]|1[0-2])-([1-9]|[12]\\d|3[01])$");

    @Override
    public LocalDate handleRequest(String request) {
        Matcher matcher = DATE_PATTERN.matcher(request);
        if (matcher.find()) {
            int year = Integer.parseInt(matcher.group(1));
            int month = Integer.parseInt(matcher.group(2));
            int day = Integer.parseInt(matcher.group(3));
            return LocalDate.of(year, month, day);
        } else {
            return next.handleRequest(request);
        }
    }
}
