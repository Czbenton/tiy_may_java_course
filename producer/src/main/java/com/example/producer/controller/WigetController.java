package com.example.producer.controller;

import com.example.producer.Widget;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zach on 8/2/17.
 */
@RestController
public class WigetController {
    private List<Widget> widgets = new ArrayList<Widget>() {
    };

    @RequestMapping("/api/v1/widgets")
    public List<Widget> getWidgets() {

        if (widgets.isEmpty()) {
            init(widgets);
        }

        return widgets;
    }


    private void init(List<Widget> widgets) {
        LocalDate releasedate = LocalDate.of(2017, 11, 12);
        Widget widget1 = new Widget("neato", "V1.2", releasedate);
        Widget widget2 = new Widget("bo", "V2.3", releasedate);
        Widget widget3 = new Widget("beto", "V3.1", releasedate);

        widgets.add(widget1);
        widgets.add(widget2);
        widgets.add(widget3);
    }
}
