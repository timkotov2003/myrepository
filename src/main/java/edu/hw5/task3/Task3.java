package edu.hw5.task3;

import edu.hw5.task3.impl.DateHandlerImpl1;
import edu.hw5.task3.impl.DateHandlerImpl2;
import edu.hw5.task3.impl.DateHandlerImpl3;
import edu.hw5.task3.impl.DateHandlerImpl4;
import edu.hw5.task3.impl.DateHandlerImpl5;
import edu.hw5.task3.impl.DateHandlerImpl6;
import edu.hw5.task3.impl.DateHandlerImpl7;
import java.time.LocalDate;
import java.util.Optional;

public class Task3 {

    private Task3() {
    }

    public static Optional<LocalDate> parseDate(String string) {
        BaseDateHandler baseDateHandler1 = new DateHandlerImpl1();
        BaseDateHandler baseDateHandler2 = new DateHandlerImpl2();
        BaseDateHandler baseDateHandler3 = new DateHandlerImpl3();
        BaseDateHandler baseDateHandler4 = new DateHandlerImpl4();
        BaseDateHandler baseDateHandler5 = new DateHandlerImpl5();
        BaseDateHandler baseDateHandler6 = new DateHandlerImpl6();
        BaseDateHandler baseDateHandler7 = new DateHandlerImpl7();
        baseDateHandler1.setNext(baseDateHandler2);
        baseDateHandler2.setNext(baseDateHandler3);
        baseDateHandler3.setNext(baseDateHandler4);
        baseDateHandler4.setNext(baseDateHandler5);
        baseDateHandler5.setNext(baseDateHandler6);
        baseDateHandler6.setNext(baseDateHandler7);

        LocalDate date = baseDateHandler1.handleRequest(string);
        if (date == null) {
            return Optional.empty();
        } else {
            return Optional.of(date);
        }
    }

}
