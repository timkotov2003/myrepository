package edu.hw5.task3.impl;

import edu.hw5.task3.BaseDateHandler;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("MagicNumber")
public class DateHandlerImpl2 extends BaseDateHandler {

    private static final Pattern DATE_PATTERN = Pattern.compile("^(\\d{1,2})\\/(\\d{1,2})\\/(\\d{1,4})$");

    @Override
    public LocalDate handleRequest(String request) {
        Matcher matcher = DATE_PATTERN.matcher(request);
        if (matcher.find()) {
            int year = Integer.parseInt(matcher.group(3));
            int month = Integer.parseInt(matcher.group(2));
            int day = Integer.parseInt(matcher.group(1));
            return LocalDate.of(year, month, day);
        } else {
            return next.handleRequest(request);
        }
    }
}
