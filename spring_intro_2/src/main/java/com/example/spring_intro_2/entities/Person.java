package com.example.spring_intro_2.entities;

/**
 * Created by Zach on 8/1/17.
 */
public class Person {
    String name;
    Contact contactInfo;

    public Person() {
    }

    public Person(String name, Contact contactInfo) {
        this.name = name;
        this.contactInfo = contactInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Contact getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(Contact contactInfo) {
        this.contactInfo = contactInfo;
    }
}

