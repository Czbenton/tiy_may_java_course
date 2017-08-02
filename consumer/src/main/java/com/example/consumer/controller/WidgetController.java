package com.example.consumer.controller;

import com.example.consumer.Widget;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

/**
 * Created by Zach on 8/2/17.
 */
@Controller
public class WidgetController {

    private String producer_URL = "http://localhost:9090/api/v1/widgets";

    @RequestMapping("/widgets")
    public String getWidgets(Model model){

        RestTemplate restTemplate = new RestTemplate();
        ArrayList<Widget> widgets = restTemplate.getForObject(producer_URL, ArrayList.class);

        model.addAttribute("widgets", widgets);

        return "Widgets";
    }

}
