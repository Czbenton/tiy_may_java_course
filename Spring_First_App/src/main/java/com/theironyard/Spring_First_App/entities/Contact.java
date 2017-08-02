package com.theironyard.Spring_First_App.entities;


/**
 * Created by Zach on 8/1/17.
 */
public class Contact {
    String email;
    String cell;
    String website;

    public Contact() {
    }

    public Contact(String email, String cell, String website) {
        this.email = email;
        this.cell = cell;
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
