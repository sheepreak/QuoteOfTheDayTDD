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

  @Autowired private MockMvc mockMvc;

  @Autowired private QuoteLibrary quoteLibrary;

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
    String response =
        mockMvc.perform(get("/quoteOfTheDay")).andReturn().getResponse().getContentAsString();

    Assertions.assertTrue(quoteLibrary.getQuotes().contains(response));
  }

  @DisplayName("Endpoint should not return same quote with two successive calls")
  @Test
  @SneakyThrows
  void should_return_two_different_quotes_with_two_calls() {
    String response1 =
        mockMvc.perform(get("/quoteOfTheDay")).andReturn().getResponse().getContentAsString();
    String response2 =
        mockMvc.perform(get("/quoteOfTheDay")).andReturn().getResponse().getContentAsString();

    Assertions.assertNotEquals(response1, response2);
  }

  @DisplayName("Endpoint should return a 404 error when giving a paramter that doesn't exist")
  @Test
  @SneakyThrows
  void should_return_not_found_with_unknown_parameter() {
    mockMvc
        .perform(get("/quoteOfTheDay").param("q", "ruigbrigrieg"))
        .andExpect(status().isNotFound());
  }

  @DisplayName("Endpoint with correct parameter returns a quote containing that parameter")
  @Test
  @SneakyThrows
  void should_return_quote_with_given_parameter() {
    String parameter = "sloubi";

    String response =
        mockMvc
            .perform(get("/quoteOfTheDay").param("q", parameter))
            .andReturn()
            .getResponse()
            .getContentAsString();

    Assertions.assertTrue(response.contains(parameter));
  }
}
