package com.zipcodewilmington.phonebook;

import jdk.nashorn.internal.ir.WhileNode;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    private SortedMap<String, ArrayList<String>> phoneBook = new TreeMap<>();

    //constructor
    public PhoneBook() {
    }

    public PhoneBook(String name, ArrayList phone) {
        this.phoneBook.put(name, phone);
    }

    //adds an entry to the composite associate data type
    public void add(String name, ArrayList phoneList) {
        phoneBook.put(name, phoneList);
    }

    //Check if there is an entry in the phone book
    public boolean hasEntry(String name) {
        boolean bool = false;
        if (phoneBook.containsKey(name)) {
            bool = true;
        } else {
            bool = false;
        }

        return bool;
    }

    //removes an entry to the composite associate data type
    public void removeRecord(String name,ArrayList phoneList) {
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

    //returns a name for the respective input phoneNumber
    public String reverseLookup(String phoneNumber) {
        String key = "";
        for (Map.Entry<String, ArrayList<String>> entry : phoneBook.entrySet())
        {
           // String phoneList = String.join(",",entry.getValue());

            if (entry.getValue().toString().contains(phoneNumber)){
                key = entry.getKey();
            }
        }
        return key;
    }

    //print a human-readable list of all entries (names and phone numbers) in alphabetical order.
    public void displayList() {
        String key = "";
        ArrayList<String> value = null;
        String finalPhone = "";
        for (Map.Entry<String, ArrayList<String>> entry : phoneBook.entrySet()) {
            key = entry.getKey();
            value = entry.getValue();

            finalPhone = finalPhone.join(",",value );
            System.out.printf("Name: %s " + "Number: %s", key, finalPhone);
        }
    }

    public String[] lookupNumbers(String name) {
        ArrayList<String> phoneList;

        if (phoneBook.containsKey(name)) {
             phoneList = phoneBook.get(name);

        } else {
            phoneList = null;
        }
        String[] numbersList = new String[phoneList.size()];
        for (int i = 0;i<phoneList.size();i++) {

            numbersList[i] = phoneList.get(i);
        }
        return numbersList;
    }

  /*  public String lookUp(){
       String string = "";
        return string;

    }


  /*
    public String listNames(String name) {
    String listNames = "";
    return listNames;
    }

    public String listNamesAndNumbers(String name) {
     return string;
    }

     public void add(String, string ...) {

    }

     public void removeRecord(String name) {

    }

    //get keys from values in the TreeMap
    public static <T, E> Set<T> getKeysByValue(PhoneBook<T, E> map, E value) {

    }

*/

}
