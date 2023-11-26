package edu.hw7.task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SynchronizedPDImpl implements PersonDatabase {

    private final Map<String, List<Person>> nameCache;
    private final Map<String, List<Person>> addressCache;
    private final Map<String, List<Person>> phoneNumberCache;
    private final Map<Integer, Person> database;

    public SynchronizedPDImpl() {
        nameCache = new HashMap<>();
        addressCache = new HashMap<>();
        phoneNumberCache = new HashMap<>();
        database = new HashMap<>();
    }

    @Override
    public synchronized void add(Person person) {
        database.put(person.id(), person);
        nameCache.computeIfAbsent(person.name(), key -> new ArrayList<>()).add(person);
        addressCache.computeIfAbsent(person.address(), key -> new ArrayList<>()).add(person);
        phoneNumberCache.computeIfAbsent(person.phoneNumber(), key -> new ArrayList<>()).add(person);
    }

    @Override
    public synchronized void delete(int id) {
        nameCache.remove(database.get(id).name());
        addressCache.remove(database.get(id).address());
        phoneNumberCache.remove(database.get(id).phoneNumber());
        database.remove(id);
    }

    @Override
    public synchronized List<Person> findByName(String name) {
        return nameCache.get(name);
    }

    @Override
    public synchronized List<Person> findByAddress(String address) {
        return addressCache.get(address);
    }

    @Override
    public synchronized List<Person> findByPhone(String phone) {
        return phoneNumberCache.get(phone);
    }
}
