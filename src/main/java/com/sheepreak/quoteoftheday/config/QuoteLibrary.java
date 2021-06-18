package com.sheepreak.quoteoftheday.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(value = "dataset")
@Getter
@AllArgsConstructor
public class QuoteLibrary {

    private List<String> quotes;
}
