package com.sheepreak.quoteoftheday.service;

import com.sheepreak.quoteoftheday.config.QuoteLibrary;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
@RequiredArgsConstructor
public class QuoteService {

    private final QuoteLibrary quoteLibrary;

    // SecureRandom makes the call to a random int thread-safe, allowing for 2 successive users not to have the same quote 
    private SecureRandom secureRandom = new SecureRandom();

    public String getRandomQuoteFromLibrary() {
        return quoteLibrary.getQuotes().get(secureRandom.nextInt(quoteLibrary.getQuotes().size() - 1));
    }
}
