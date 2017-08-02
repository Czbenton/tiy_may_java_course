package com.theironyard.Spring_First_App.controllers;

import com.theironyard.Spring_First_App.entities.Contact;
import com.theironyard.Spring_First_App.entities.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by Zach on 8/1/17.
 */
@Controller
public class BasicController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home (Model model) {

        Person zach = new Person("Zach", new Contact("zach@zach.com","615-200-5788","http://zachbenton.com"));
        model.addAttribute("person", zach);
        model.addAttribute("name", zach.getName());
        return "home";
    }

    @RequestMapping(path = "/splash", method = RequestMethod.GET)
    public String splash () {
        //Method body
        return "splash";
    }

}
