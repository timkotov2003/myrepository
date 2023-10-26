package edu.hw2.task3.connection.impl;

import edu.hw2.task3.connection.Connection;

public class StableConnection implements Connection {

    @Override
    public void execute(String command) {
        LOGGER.info("StableConnection execute");
    }

}
