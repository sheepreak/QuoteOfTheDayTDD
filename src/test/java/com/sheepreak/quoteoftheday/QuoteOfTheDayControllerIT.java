package com.sheepreak.quoteoftheday;

import com.sheepreak.quoteoftheday.config.QuoteLibrary;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class QuoteOfTheDayControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private QuoteLibrary quoteLibrary;

    @DisplayName("Endpoint with no argument should return 200")
    @Test
    @SneakyThrows
    void should_return_status_ok_when_calling_get() {
        mockMvc.perform(get("/quoteOfTheDay")).andExpect(status().isOk());
    }

    @DisplayName("Endpoint with no argument should return a quote from the library")
    @Test
    @SneakyThrows
    void should_return_quote_from_library_when_calling_get() {
        String response = mockMvc.perform(get("/quoteOfTheDay")).andReturn().getResponse().getContentAsString();

        Assertions.assertTrue(quoteLibrary.getQuotes().contains(response));
    }

}
