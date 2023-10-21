package edu.hw2.task3.connection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface Connection extends AutoCloseable {

    Logger LOGGER = LogManager.getLogger();

    void execute(String command);

    @Override
    default void close() throws Exception {
        LOGGER.info("close connection");
    }
}
