package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {

    private SortedMap<String, ArrayList<String>> phoneBook = new TreeMap<String, ArrayList<String>>();

    @Test
    public void constructorTest() {
        //Given
        String expectedName = "John";
        ArrayList<String> expectedPhone = new ArrayList<String>();
        expectedPhone.add("212-343-5935");
        //When
        PhoneBook phoneBookObj = new PhoneBook(expectedName,expectedPhone);
        boolean bool = phoneBookObj.hasEntry(expectedName);
        //Then
        Assert.assertTrue(bool);
    }

    @Test
    public void addTest() {
        //Given
        String expectedName = "Sal";
        ArrayList<String> expectedPhone = new ArrayList<String>();
        expectedPhone.add("565-343-9685");
        expectedPhone.add("292-324-9058");
        //When
        PhoneBook phoneBookObj = new PhoneBook();
        phoneBookObj.add(expectedName, expectedPhone);
        boolean bool = phoneBookObj.hasEntry(expectedName);
        //Then
        Assert.assertTrue(bool);
    }

    @Test
    public void removeRecordTest(){
        //Given
        String expectedName = "Ced";
        ArrayList<String> expectedPhone = new ArrayList<String>();
        expectedPhone.add("111-343-3546");
        expectedPhone.add("911-324-9000");
        String expectedName2 = "John";
        ArrayList<String> expectedPhone2 = new ArrayList<String>();
        expectedPhone2.add("212-343-5935");
        PhoneBook phoneBookObj = new PhoneBook();
        phoneBookObj.add(expectedName, expectedPhone);
        phoneBookObj.add(expectedName2,expectedPhone2);
        //When
        phoneBookObj.removeRecord(expectedName,expectedPhone);
        phoneBookObj.removeRecord(expectedName2,expectedPhone2);
        boolean bool = phoneBookObj.hasEntry(expectedName);
        boolean bool2 = phoneBookObj.hasEntry(expectedName);
        //Then
        Assert.assertFalse(bool);
        Assert.assertFalse(bool2);
    }

    @Test
    public void getPhoneNumbersListTest(){
        //Given
        String expectedName = "Ced";
       // Integer expectedPhoneList = 2;
        ArrayList<String> expectedPhone = new ArrayList<String>();
        expectedPhone.add("111-343-3546");
        expectedPhone.add("911-324-9000");
        String expectedPhoneList = String.join(",",expectedPhone);
        //When
        PhoneBook phoneBookObj = new PhoneBook();
        phoneBookObj.add(expectedName, expectedPhone);
        ArrayList actualPhone = phoneBookObj.getPhoneNumbersList(expectedName);
        String actualPhoneList = "";
        for (int i =0;i<phoneBookObj.getPhoneNumbersList(expectedName).size();i++) {

            actualPhoneList = String.join(",",actualPhone);
        }
        phoneBookObj.displayList();
        //Then
        Assert.assertEquals(expectedPhoneList,actualPhoneList);
    }

    @Test
    public void getNameFromPhoneListTest(){
        //Given
        String expectedName = "Sal";
        ArrayList<String> expectedPhone = new ArrayList<String>();
        expectedPhone.add("565-343-9685");
        //When
        PhoneBook phoneBookObj = new PhoneBook();
        phoneBookObj.add(expectedName, expectedPhone);
        String actualName = phoneBookObj.reverseLookup(expectedPhone);
        //Then
        Assert.assertEquals(expectedName,actualName);
    }

}
