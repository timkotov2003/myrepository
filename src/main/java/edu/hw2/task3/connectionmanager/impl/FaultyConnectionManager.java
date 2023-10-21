package edu.hw2.task3.connectionmanager.impl;

import edu.hw2.task3.connection.Connection;
import edu.hw2.task3.connection.impl.FaultyConnection;
import edu.hw2.task3.connectionmanager.ConnectionManager;

public class FaultyConnectionManager implements ConnectionManager {

    @Override
    public Connection getConnection() {
        return new FaultyConnection();
    }
}
