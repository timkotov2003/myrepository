package edu.hw3.task5;

import java.util.Arrays;
import java.util.Comparator;

public class Task5 {

    private Task5() {
    }

    public static Contact[] parseContacts(String[] dataOfPeople, SortType sortType) {
        if (dataOfPeople == null || dataOfPeople.length == 0) {
            return new Contact[0];
        }
        Contact[] contacts = new Contact[dataOfPeople.length];
        for (int i = 0; i < dataOfPeople.length; i++) {
            contacts[i] = getContactFromString(dataOfPeople[i]);
        }
        Comparator<Contact> comp = sortType == SortType.ASC ? Comparator.naturalOrder() : Comparator.reverseOrder();
        Arrays.sort(contacts, comp);
        return contacts;
    }

    private static Contact getContactFromString(String str) {
        if (str.contains(" ")) {
            String[] data = str.split(" ");
            return new Contact(data[0], data[1]);
        } else {
            return new Contact(str, null);
        }
    }
}
