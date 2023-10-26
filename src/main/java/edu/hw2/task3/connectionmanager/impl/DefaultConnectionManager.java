package edu.hw2.task3.connectionmanager.impl;

import edu.hw2.task3.connection.Connection;
import edu.hw2.task3.connection.impl.FaultyConnection;
import edu.hw2.task3.connection.impl.StableConnection;
import edu.hw2.task3.connectionmanager.ConnectionManager;
import java.util.Random;

public class DefaultConnectionManager implements ConnectionManager {

    @Override
    public Connection getConnection() {
        return new Random().nextBoolean() ? new StableConnection() : new FaultyConnection();
    }
}
