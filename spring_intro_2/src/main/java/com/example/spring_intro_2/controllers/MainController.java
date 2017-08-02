package com.example.spring_intro_2.controllers;

import com.example.spring_intro_2.entities.Contact;
import com.example.spring_intro_2.entities.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by Zach on 8/1/17.
 */
@Controller
public class MainController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String homeRoute (Model model){

        LocalDate birthday = LocalDate.of(1987,11,11);
        Person zach = new Person("zach", new Contact("234234234", "zachbenton.com", birthday));

        model.addAttribute("person", zach);
        model.addAttribute("birthday", zach.getContactInfo().getBirthday());

        return "home";
    }



}
