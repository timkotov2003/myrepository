package edu.hw2.task3.connection.impl;

import edu.hw2.task3.connection.Connection;
import edu.hw2.task3.exception.ConnectionException;
import java.util.Random;

public class FaultyConnection implements Connection {

    @Override
    public void execute(String command) {
        if (new Random().nextBoolean()) {
            throw new ConnectionException("FaultyConnection error");
        }
        LOGGER.info("FaultyConnection execute");
    }

}
