package com.sheepreak.quoteoftheday.service;

import com.sheepreak.quoteoftheday.config.QuoteLibrary;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuoteService {

    private final QuoteLibrary quoteLibrary;

    public String getRandomQuoteFromLibrary() {
        return quoteLibrary.getQuotes().get(0);
    }
}
