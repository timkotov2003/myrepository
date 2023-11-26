package edu.hw7.task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockPDImpl implements PersonDatabase {

    private final Map<String, List<Person>> nameCache;
    private final Map<String, List<Person>> addressCache;
    private final Map<String, List<Person>> phoneNumberCache;
    private final Map<Integer, Person> database;
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public ReadWriteLockPDImpl() {
        nameCache = new HashMap<>();
        addressCache = new HashMap<>();
        phoneNumberCache = new HashMap<>();
        database = new HashMap<>();
    }

    @Override
    public void add(Person person) {
        readWriteLock.writeLock().lock();
        try {
            database.put(person.id(), person);
            nameCache.computeIfAbsent(person.name(), key -> new ArrayList<>()).add(person);
            addressCache.computeIfAbsent(person.address(), key -> new ArrayList<>()).add(person);
            phoneNumberCache.computeIfAbsent(person.phoneNumber(), key -> new ArrayList<>()).add(person);
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    @Override
    public void delete(int id) {
        readWriteLock.writeLock().lock();
        try {
            nameCache.remove(database.get(id).name());
            addressCache.remove(database.get(id).address());
            phoneNumberCache.remove(database.get(id).phoneNumber());
            database.remove(id);
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    @Override
    public List<Person> findByName(String name) {
        readWriteLock.readLock().lock();
        try {
            return nameCache.get(name);
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    @Override
    public List<Person> findByAddress(String address) {
        readWriteLock.readLock().lock();
        try {
            return addressCache.get(address);
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    @Override
    public List<Person> findByPhone(String phone) {
        readWriteLock.readLock().lock();
        try {
            return phoneNumberCache.get(phone);
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}
