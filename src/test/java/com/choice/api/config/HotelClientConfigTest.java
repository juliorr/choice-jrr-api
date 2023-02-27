package com.choice.api.config;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import com.choice.api.client.HotelClient;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

class HotelClientConfigTest {

  private HotelClientConfig hotelClientConfig;

  @BeforeEach
  void setUp() {
    hotelClientConfig = new HotelClientConfig();
  }

  @AfterEach
  void tearDown() {
    hotelClientConfig = null;
  }

  @Test
  void marshaller() {
    Jaxb2Marshaller response = hotelClientConfig.marshaller();
    assertEquals("com.choice.api.gen", response.getContextPath());
  }

  @Test
  void countryClient() {
    Jaxb2Marshaller jaxb2Marshaller = hotelClientConfig.marshaller();
    HotelClient hotelClient = hotelClientConfig.countryClient(jaxb2Marshaller);
    assertEquals("http://localhost:8081/ws", hotelClient.getDefaultUri());
  }
}