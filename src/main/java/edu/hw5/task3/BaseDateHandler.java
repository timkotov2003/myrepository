package edu.hw5.task3;

import java.time.LocalDate;

public abstract class BaseDateHandler {

    protected BaseDateHandler next;

    public void setNext(BaseDateHandler next) {
        this.next = next;
    }

    public abstract LocalDate handleRequest(String request);
}
