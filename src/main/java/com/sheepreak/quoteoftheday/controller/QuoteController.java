package com.sheepreak.quoteoftheday.controller;

import com.sheepreak.quoteoftheday.service.QuoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Pattern;

@RestController
@RequestMapping("/quoteOfTheDay")
@RequiredArgsConstructor
@Validated
public class QuoteController {

  private final QuoteService quoteService;

  @GetMapping
  public String getQuoteOfTheDay(
      @RequestParam(required = false) @Pattern(regexp = "[a-zA-Z0-9 ]*") String q) {
    return quoteService.getRandomQuoteFromLibrary(q);
  }
}
