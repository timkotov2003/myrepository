package edu.hw3.task6;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class StockMarketImpl implements StockMarket {

    private final Queue<Stock> innerQueue = new PriorityQueue(Comparator.comparing(Stock::price).reversed());

    @Override
    public void add(Stock stock) {
        innerQueue.add(stock);
    }

    @Override
    public void remove(Stock stock) {
        innerQueue.remove(stock);
    }

    @Override
    public Stock mostValuableStock() {
        return innerQueue.peek();
    }
}
