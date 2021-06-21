package com.sheepreak.quoteoftheday.controller;

import com.sheepreak.quoteoftheday.service.QuoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Pattern;

@RestController
@RequestMapping("/quoteOfTheDay")
@RequiredArgsConstructor
@Validated
public class QuoteController {

  private final QuoteService quoteService;

  // added a StringTrimmer so that a String parameter is trimmed directly when received through an endpoint call
  // with true given as a parameter for the String trimmer, en empty string will be handled as null
  @InitBinder()
  public void initBinder(WebDataBinder binder) {
    binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
  }

  @GetMapping
  public String getQuoteOfTheDay(
      @RequestParam(required = false) @Pattern(regexp = "[a-zA-Z0-9 ]*") String q) {
    return quoteService.getRandomQuoteFromLibrary(q);
  }
}
