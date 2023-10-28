package edu.hw3.task8;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class BackwardIterator<E> implements Iterator<E> {

    private final ListIterator<E> listIterator;

    public BackwardIterator(List<E> list) {
        this.listIterator = list.listIterator(list.size());
    }

    @Override
    public boolean hasNext() {
        return listIterator.hasPrevious();
    }

    @Override
    public E next() {
        return listIterator.previous();
    }
}
