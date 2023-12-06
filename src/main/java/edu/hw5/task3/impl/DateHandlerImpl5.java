package edu.hw5.task3.impl;

import edu.hw5.task3.BaseDateHandler;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateHandlerImpl5 extends BaseDateHandler {

    private static final Pattern DATE_PATTERN = Pattern.compile("yesterday", Pattern.CASE_INSENSITIVE);

    @Override
    public LocalDate handleRequest(String request) {
        Matcher matcher = DATE_PATTERN.matcher(request);
        if (matcher.find()) {
            return LocalDate.now().minusDays(1);
        } else {
            return next.handleRequest(request);
        }
    }
}
