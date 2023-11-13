package edu.hw5.task3.impl;

import edu.hw5.task3.DateHandler;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateHandler6 extends DateHandler {

    private static final Pattern DATE_PATTERN = Pattern.compile("([1-9]\\d*) days? ago", Pattern.CASE_INSENSITIVE);

    @Override
    public LocalDate handleRequest(String request) {
        Matcher matcher = DATE_PATTERN.matcher(request);
        if (matcher.find()) {
            int daysAgo = Integer.parseInt(matcher.group(1));
            return LocalDate.now().minusDays(daysAgo);
        } else {
            return next.handleRequest(request);
        }
    }
}
