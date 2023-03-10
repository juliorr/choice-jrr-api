package com.choice.api.controller;

import com.choice.api.client.HotelClientInterface;
import com.choice.api.gen.CreateHotelResponse;
import com.choice.api.gen.DeleteHotelResponse;
import com.choice.api.gen.GetListResponse;
import com.choice.api.gen.Hotel;
import com.choice.api.gen.SearchByNameResponse;
import com.choice.api.gen.UpdateHotelResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelController {

  private final HotelClientInterface hotelClient;

  public HotelController(HotelClientInterface hotelClient) {
    this.hotelClient = hotelClient;
  }

  @GetMapping("/hotel/{id}")
  public Hotel get(@PathVariable("id") Integer id) {
    return hotelClient.get(id).getHotel();
  }

  @GetMapping("/hotels")
  public GetListResponse getList(@RequestParam int page, @RequestParam int size) {
    return hotelClient.getList(page, size);
  }

  @PostMapping("/hotel")
  public CreateHotelResponse add(@RequestBody Hotel hotel) {
    return hotelClient.add(hotel);
  }

  @PutMapping("/hotel")
  public UpdateHotelResponse update(@RequestBody Hotel hotel) {
    return hotelClient.update(hotel);
  }

  @DeleteMapping("/hotel/{id}")
  public DeleteHotelResponse delete(@PathVariable("id") Integer id) {
    return hotelClient.delete(id);
  }

  @GetMapping("/hotel")
  public SearchByNameResponse search(@RequestParam String search, @RequestParam int page, @RequestParam int size) {
    return hotelClient.search(search, page, size);
  }
}
