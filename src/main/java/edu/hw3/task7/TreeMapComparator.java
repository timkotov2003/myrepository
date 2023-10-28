package edu.hw3.task7;

import java.util.Comparator;

public class TreeMapComparator<T extends Comparable<T>> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        if (o1 == null || o2 == null) {
            return 0;
        }
        return o1.compareTo(o2);
    }
}
