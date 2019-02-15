package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {

    //private SortedMap<String, ArrayList<String>> phoneBook = new TreeMap<>();
    private PhoneBook phoneBookObj;
@Before
    public void initial(){
        phoneBookObj = new PhoneBook();
}
    @Test
    public void constructorTest() {
        //Given
        String expectedName = "John";
        ArrayList<String> expectedPhone = new ArrayList<String>();
        expectedPhone.add("212-343-5935");
        //When
        phoneBookObj = new PhoneBook(expectedName,expectedPhone);
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
        ArrayList<String> expectedPhone = new ArrayList<String>();
        expectedPhone.add("111-343-3546");
        expectedPhone.add("911-324-9000");
        String expectedPhoneList = String.join(",",expectedPhone);
        //When
        phoneBookObj.add(expectedName, expectedPhone);
        ArrayList actualPhone = phoneBookObj.getPhoneNumbersList(expectedName);
        String actualPhoneList = "";
        for (int i =0;i<phoneBookObj.getPhoneNumbersList(expectedName).size();i++) {

            actualPhoneList = String.join(",",actualPhone);
        }
        //Then
        Assert.assertEquals(expectedPhoneList,actualPhoneList);
    }

    @Test
    public void lookupNumbersTest(){
        //Given
        String expectedName = "Sal";
        ArrayList<String> expectedPhoneList = new ArrayList<>();
        expectedPhoneList.add("111-534-5563");
        //When
        phoneBookObj.add(expectedName,expectedPhoneList);
        String[] actualPhoneList = phoneBookObj.lookupNumbers(expectedName);
        ArrayList<String> actualPhone = new ArrayList<>(Arrays.asList(actualPhoneList));
        //Then
        Assert.assertEquals(expectedPhoneList,actualPhone);
    }

    @Test
    public void reverseLookupTest()
    {
        //Given
        String expectedName = "Sal";
        ArrayList<String> expectedPhoneList = new ArrayList<>();
        expectedPhoneList.add("111-534-5563");
        expectedPhoneList.add("222-534-5563");
        String expectedPhone = "111-534-5563";
        //When
        phoneBookObj.add(expectedName,expectedPhoneList);
        String actualName = phoneBookObj.reverseLookup(expectedPhone);
        //Then
        phoneBookObj.displayList();
        Assert.assertEquals(expectedName,actualName);
    }
}
