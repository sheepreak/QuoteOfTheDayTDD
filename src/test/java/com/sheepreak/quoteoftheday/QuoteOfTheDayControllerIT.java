package com.sheepreak.quoteoftheday;

import lombok.SneakyThrows;
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

    @Test
    @SneakyThrows
    void should_return_status_ok_when_calling_get() {
        mockMvc.perform(get("/quoteOfTheDay")).andExpect(status().isOk());
    }

}
