package com.theironyard.Spring_First_App.entities;

/**
 * Created by Zach on 8/1/17.
 */
public class Person {
    String name;
    Contact contact;


    public Person(String name, Contact contact) {
        this.name = name;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
