package com.sheepreak.quoteoftheday.service;

import com.sheepreak.quoteoftheday.config.QuoteLibrary;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.security.SecureRandom;

@Service
@RequiredArgsConstructor
public class QuoteService {

  private final QuoteLibrary quoteLibrary;

  // SecureRandom makes the call to a random int thread-safe, allowing for 2 successive users not to
  // have the same quote
  private SecureRandom secureRandom = new SecureRandom();

  public String getRandomQuoteFromLibrary(String q) {
    if (q != null) {
      return quoteLibrary.getQuotes().stream()
          .filter(quote -> quote.contains(q.trim()))
          .findAny()
          .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    } else {
      return quoteLibrary
          .getQuotes()
          .get(secureRandom.nextInt(quoteLibrary.getQuotes().size() - 1));
    }
  }
}
