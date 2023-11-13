package edu.hw5.task3;

import edu.hw5.task3.impl.DateHandler1;
import edu.hw5.task3.impl.DateHandler2;
import edu.hw5.task3.impl.DateHandler3;
import edu.hw5.task3.impl.DateHandler4;
import edu.hw5.task3.impl.DateHandler5;
import edu.hw5.task3.impl.DateHandler6;
import edu.hw5.task3.impl.DateHandler7;
import java.time.LocalDate;
import java.util.Optional;

public class Task3 {

    private Task3() {
    }

    public static Optional<LocalDate> parseDate(String string) {
        DateHandler dateHandler1 = new DateHandler1();
        DateHandler dateHandler2 = new DateHandler2();
        DateHandler dateHandler3 = new DateHandler3();
        DateHandler dateHandler4 = new DateHandler4();
        DateHandler dateHandler5 = new DateHandler5();
        DateHandler dateHandler6 = new DateHandler6();
        DateHandler dateHandler7 = new DateHandler7();
        dateHandler1.setNext(dateHandler2);
        dateHandler2.setNext(dateHandler3);
        dateHandler3.setNext(dateHandler4);
        dateHandler4.setNext(dateHandler5);
        dateHandler5.setNext(dateHandler6);
        dateHandler6.setNext(dateHandler7);

        LocalDate date = dateHandler1.handleRequest(string);
        if (date == null) {
            return Optional.empty();
        } else {
            return Optional.of(date);
        }
    }

}
