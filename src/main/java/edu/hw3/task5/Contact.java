package edu.hw3.task5;

public record Contact(String firstName, String lastName) implements Comparable<Contact> {

    private String getNotNullName() {
        return lastName == null ? firstName : lastName;
    }

    @Override
    public int compareTo(Contact o) {
        return getNotNullName().compareTo(o.getNotNullName());
    }
}
