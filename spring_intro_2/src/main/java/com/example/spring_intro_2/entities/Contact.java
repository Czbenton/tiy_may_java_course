package com.example.spring_intro_2.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by Zach on 8/1/17.
 */
public class Contact {
    String phone;
    String website;
    LocalDate birthday;

    public Contact() {
    }

    public Contact(String phone, String website, LocalDate birthday) {
        this.phone = phone;
        this.website = website;
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
