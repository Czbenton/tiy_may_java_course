package com.example.REST_Lesson.controller;

import com.example.REST_Lesson.RandomQuoteResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static com.example.REST_Lesson.RestLessonApplication.API_URL;

/**
 * Created by Zach on 8/2/17.
 */
@RestController
public class Controller {

    //Here is our first endpoint
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String getQuote() {
        RestTemplate restTemplate = new RestTemplate();
        RandomQuoteResponse quote = restTemplate.getForObject(API_URL, RandomQuoteResponse.class);

        return quote;
    }
}