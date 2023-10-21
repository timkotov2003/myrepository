package edu.hw2.task3;

import edu.hw2.task3.connection.Connection;
import edu.hw2.task3.connectionmanager.ConnectionManager;
import edu.hw2.task3.exception.ConnectionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class PopularCommandExecutor {
    private static final Logger LOGGER = LogManager.getLogger();
    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    void tryExecute(String command) {
        for (int i = 0; i < maxAttempts; i++) {
            try (Connection con = manager.getConnection()) {
                con.execute(command);
                LOGGER.info("succes!");
                return;
            } catch (Exception e) {
                LOGGER.info("connection failed");
                if (i == maxAttempts - 1) {
                    throw new ConnectionException("sorry " + e.getMessage(), e.getCause());
                }
            }
        }
    }
}
