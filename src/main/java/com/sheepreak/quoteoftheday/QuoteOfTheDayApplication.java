package com.sheepreak.quoteoftheday;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class QuoteOfTheDayApplication {

  // removed the args from the spring application run because no parameter overloading is done
  public static void main(String[] args) {
    SpringApplication.run(QuoteOfTheDayApplication.class);
  }
}
