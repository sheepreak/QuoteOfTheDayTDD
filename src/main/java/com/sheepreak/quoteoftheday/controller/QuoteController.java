package com.sheepreak.quoteoftheday.controller;

import com.sheepreak.quoteoftheday.service.QuoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quoteOfTheDay")
@RequiredArgsConstructor
public class QuoteController {

    private final QuoteService quoteService;

    @GetMapping
    public String getQuoteOfTheDay() {
        return quoteService.getRandomQuoteFromLibrary();
    }
}
