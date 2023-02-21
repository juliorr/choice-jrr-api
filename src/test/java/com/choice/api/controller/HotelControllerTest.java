package com.choice.api.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;

import com.choice.api.client.HotelClient;
import com.choice.api.client.HotelClientInterface;
import com.choice.api.gen.CreateHotelResponse;
import com.choice.api.gen.DeleteHotelResponse;
import com.choice.api.gen.GetHotelResponse;
import com.choice.api.gen.GetListResponse;
import com.choice.api.gen.Hotel;
import com.choice.api.gen.UpdateHotelResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class HotelControllerTest {

  private HotelController hotelController;
  private HotelClientInterface hotelClient;

  @BeforeEach
  void setUp() {
    hotelClient = mock(HotelClient.class);
    hotelController = new HotelController(hotelClient);
  }

  @AfterEach
  void tearDown() {
    hotelController = null;
    hotelClient = null;
  }

  @Test
  void get() {
    GetHotelResponse getHotelResponse = new GetHotelResponse();
    Hotel hotel = new Hotel();
    hotel.setName("some name");
    getHotelResponse.setHotel(hotel);
    Mockito.when(hotelClient.get(anyInt())).thenReturn(getHotelResponse);
    Hotel response = hotelController.get(1);
    assertEquals("some name", response.getName());
  }

  @Test
  void getList() {
    GetListResponse getListResponse = new GetListResponse();
    Hotel hotel = new Hotel();
    hotel.setName("some name");
    getListResponse.getHotels().add(hotel);
    Mockito.when(hotelClient.getList(anyInt(), anyInt())).thenReturn(getListResponse);
    GetListResponse response = hotelController.getList(1, 2);
    assertEquals(1, response.getHotels().size());
  }

  @Test
  void add() {
    CreateHotelResponse createHotelResponse = new CreateHotelResponse();
    Hotel hotel = new Hotel();
    hotel.setName("some name");
    createHotelResponse.setHotel(hotel);
    Mockito.when(hotelClient.add(any(Hotel.class))).thenReturn(createHotelResponse);
    CreateHotelResponse response = hotelController.add(hotel);
    assertEquals("some name", response.getHotel().getName());
  }

  @Test
  void update() {
    UpdateHotelResponse updateHotelResponse = new UpdateHotelResponse();
    Hotel hotel = new Hotel();
    hotel.setName("some name");
    updateHotelResponse.setHotel(hotel);
    Mockito.when(hotelClient.update(any(Hotel.class))).thenReturn(updateHotelResponse);
    UpdateHotelResponse response = hotelController.update(hotel);
    assertEquals("some name", response.getHotel().getName());
  }

  @Test
  void delete() {
    DeleteHotelResponse deleteHotelResponse = new DeleteHotelResponse();
    deleteHotelResponse.setMessage("done");
    Mockito.when(hotelClient.delete(anyInt())).thenReturn(deleteHotelResponse);
    DeleteHotelResponse response = hotelController.delete(1);
    assertEquals("done", response.getMessage());
  }
}