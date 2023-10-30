package edu.hw3.task8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

public class BackwardIterator<E> implements Iterator<E> {

    private final ListIterator<E> listIterator;

    public BackwardIterator(Collection<E> collection) {
        this.listIterator = new ArrayList<>(collection).listIterator(collection.size());
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
