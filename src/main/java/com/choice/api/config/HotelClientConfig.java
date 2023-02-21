package com.choice.api.config;

import com.choice.api.client.HotelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class HotelClientConfig {
  @Bean
  public Jaxb2Marshaller marshaller() {
    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    marshaller.setContextPath("com.choice.api.gen");
    return marshaller;
  }
  @Bean
  public HotelClient countryClient(Jaxb2Marshaller marshaller) {
    HotelClient hotelClient = new HotelClient();
    hotelClient.setDefaultUri("http://localhost:8081/ws");
    hotelClient.setMarshaller(marshaller);
    hotelClient.setUnmarshaller(marshaller);
    return hotelClient;
  }
}
