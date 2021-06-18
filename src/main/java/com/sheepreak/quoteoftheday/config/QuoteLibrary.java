package com.sheepreak.quoteoftheday.config;

import lombok.Getter;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@PropertySource(value = "classpath:quotes.yml")
@Getter
public class QuoteLibrary {

    private List<String> quotes;
}
