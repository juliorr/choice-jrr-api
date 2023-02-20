package com.choice.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelController {

  @GetMapping("/")
  public String getHotel() {
    return "Hello Word";
  }

}
