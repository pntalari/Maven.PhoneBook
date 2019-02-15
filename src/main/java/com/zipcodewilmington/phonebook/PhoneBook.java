package com.zipcodewilmington.phonebook;

import java.util.ArrayList;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    private SortedMap<String, ArrayList<String>> phoneBook = new TreeMap<String, ArrayList<String>>();

    //constructor
    public  PhoneBook()
    {}

    public PhoneBook(String name, ArrayList phone) {
        this.phoneBook.put(name,phone);
    }

    //adds an entry to the composite associate data type
    public void add(String name, ArrayList phoneList) {
        phoneBook.put(name, phoneList);
    }

    //Check if there is an entry in the phone book
    public boolean hasEntry(String name)
    {
        boolean bool = false;
        if (phoneBook.containsKey(name))
        {bool = true;}
        else
        {bool = false;}

        return bool;
    }

    //removes an entry to the composite associate data type
    public void remove(String name, ArrayList phoneList) {
        phoneBook.remove(name);
    }

    //returns a phone number for the respective input name
    public ArrayList getPhoneNumbersList(String name) {
        if (phoneBook.containsKey(name)) {
            ArrayList<String> phoneList = phoneBook.get(name);
            return phoneList;

        } else {
            ArrayList<Integer> phoneList = new ArrayList<Integer>();
            return phoneList;
        }
    }

    //print a human-readable list of all entries (names and phone numbers) in alphabetical order.
    public void displayList() {
        System.out.printf("The list of Phone Book Names and Phone Numbers:" + phoneBook.entrySet());
    }

    /*
    public String lookup(String name) {
        return string;
    }

     public String lookupNumbersFor(String name) {
     return arrayList;
    }

    public String listNamesAndNumbers(String name) {
     return string;
    }

     public String listNames(String name) {
     return string;
    }

     public void add(String, string ...) {

    }

     public void removeRecord(String name) {

    }

    //returns a name for the respective input phoneNumber
    public void reverseLookup(String phoneNumber) {


    }

    //get keys from values in the TreeMap
    public static <T, E> Set<T> getKeysByValue(PhoneBook<T, E> map, E value) {

    }

*/

}
