package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Zach on 8/1/17.
 */
@Controller
public class ApplicationController {

    @RequestMapping(value = "/new_student",method = RequestMethod.GET)
    public String newStudent(){
        //do some stuff
        return "index";
    }

    @RequestMapping(value = "/new_student",method = RequestMethod.POST)
    public String createStudent(){
        //do some stuff
        return "redirect:/index";
    }
}
