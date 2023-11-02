package edu.hw3.task6;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class StockMarketTest {

    @Test
    void addTest() {
        StockMarket sm = new StockMarketImpl();

        sm.add(new Stock("A", 1));
        sm.add(new Stock("B", 3));
        sm.add(new Stock("C", 2));

        assertThat(sm.mostValuableStock()).isEqualTo(new Stock("B", 3));
    }

    @Test
    void addAndRemoveTest() {
        StockMarket sm = new StockMarketImpl();

        sm.add(new Stock("A", 1));
        sm.add(new Stock("B", 3));
        sm.add(new Stock("C", 2));
        sm.remove(new Stock("B", 3));

        assertThat(sm.mostValuableStock()).isEqualTo(new Stock("C", 2));
    }

    @Test
    void emptyTest() {
        StockMarket sm = new StockMarketImpl();

        sm.add(new Stock("A", 1));
        sm.add(new Stock("B", 3));
        sm.add(new Stock("C", 2));
        sm.remove(new Stock("B", 3));
        sm.remove(new Stock("A", 1));
        sm.remove(new Stock("C", 2));

        assertThat(sm.mostValuableStock()).isNull();
    }
}
