package edu.hw2;

import edu.hw2.task3.PopularCommandExecutor;
import edu.hw2.task3.connection.Connection;
import edu.hw2.task3.connection.impl.FaultyConnection;
import edu.hw2.task3.connectionmanager.ConnectionManager;
import edu.hw2.task3.connectionmanager.impl.DefaultConnectionManager;
import edu.hw2.task3.connectionmanager.impl.FaultyConnectionManager;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class Task3Test {

    @Test
    void faultyConnectionManagerTest() {
        ConnectionManager connectionManager = new FaultyConnectionManager();

        Connection connection = connectionManager.getConnection();

        assertThat(connection).isInstanceOf(FaultyConnection.class);
    }

    @Test
    void succesTest() {
        PopularCommandExecutor pce = new PopularCommandExecutor(new DefaultConnectionManager(), Integer.MAX_VALUE);

        assertThatCode(pce::updatePackages).doesNotThrowAnyException();
    }

}
