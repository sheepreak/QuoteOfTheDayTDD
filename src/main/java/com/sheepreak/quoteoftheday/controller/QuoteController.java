package com.sheepreak.quoteoftheday.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quoteOfTheDay")
public class QuoteController {

    @GetMapping
    public String getQuoteOfTheDay() {
        return "";
    }
}
