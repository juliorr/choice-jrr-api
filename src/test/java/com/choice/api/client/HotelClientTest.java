package com.choice.api.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

import com.choice.api.gen.CreateHotelRequest;
import com.choice.api.gen.CreateHotelResponse;
import com.choice.api.gen.DeleteHotelRequest;
import com.choice.api.gen.DeleteHotelResponse;
import com.choice.api.gen.GetHotelRequest;
import com.choice.api.gen.GetHotelResponse;
import com.choice.api.gen.GetListRequest;
import com.choice.api.gen.GetListResponse;
import com.choice.api.gen.Hotel;
import com.choice.api.gen.UpdateHotelRequest;
import com.choice.api.gen.UpdateHotelResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.ws.client.core.WebServiceTemplate;


class HotelClientTest {

  private HotelClient hotelClient;

  private WebServiceTemplate webServiceTemplate;

  @BeforeEach
  void setUp() {
    webServiceTemplate = mock(WebServiceTemplate.class);
    hotelClient = new HotelClient();

  }

  @AfterEach
  void tearDown() {
    hotelClient = null;
    webServiceTemplate = null;
  }

  @Test
  void get() {
    GetHotelResponse getHotelResponse = new GetHotelResponse();
    Hotel hotel = new Hotel();
    hotel.setName("some name");
    getHotelResponse.setHotel(hotel);
    Mockito.when(webServiceTemplate.marshalSendAndReceive(any(GetHotelRequest.class)))
        .thenReturn(getHotelResponse);
    hotelClient.setWebServiceTemplate(webServiceTemplate);
    GetHotelResponse response = hotelClient.get(1);
    assertEquals("some name", response.getHotel().getName());
  }

  @Test
  void getList() {
    GetListResponse getListResponse = new GetListResponse();
    Hotel hotel = new Hotel();
    hotel.setName("some name");
    getListResponse.getHotels().add(hotel);
    Mockito.when(webServiceTemplate.marshalSendAndReceive(any(GetListRequest.class)))
        .thenReturn(getListResponse);
    hotelClient.setWebServiceTemplate(webServiceTemplate);
    GetListResponse response = hotelClient.getList(1, 2);
    assertEquals(1, response.getHotels().size());
  }

  @Test
  void add() {
    CreateHotelResponse createHotelResponse = new CreateHotelResponse();
    Hotel hotel = new Hotel();
    hotel.setName("some name");
    createHotelResponse.setHotel(hotel);
    Mockito.when(webServiceTemplate.marshalSendAndReceive(any(CreateHotelRequest.class)))
        .thenReturn(createHotelResponse);
    hotelClient.setWebServiceTemplate(webServiceTemplate);
    CreateHotelResponse response = hotelClient.add(hotel);
    assertEquals("some name", response.getHotel().getName());
  }

  @Test
  void update() {
    UpdateHotelResponse updateHotelResponse = new UpdateHotelResponse();
    Hotel hotel = new Hotel();
    hotel.setName("some name");
    updateHotelResponse.setHotel(hotel);
    Mockito.when(webServiceTemplate.marshalSendAndReceive(any(UpdateHotelRequest.class)))
        .thenReturn(updateHotelResponse);
    hotelClient.setWebServiceTemplate(webServiceTemplate);
    UpdateHotelResponse response = hotelClient.update(hotel);
    assertEquals("some name", response.getHotel().getName());
  }

  @Test
  void delete() {
    DeleteHotelResponse deleteHotelResponse = new DeleteHotelResponse();
    deleteHotelResponse.setMessage("done");
    Mockito.when(webServiceTemplate.marshalSendAndReceive(any(DeleteHotelRequest.class)))
        .thenReturn(deleteHotelResponse);
    hotelClient.setWebServiceTemplate(webServiceTemplate);
    DeleteHotelResponse response = hotelClient.delete(1);
    assertEquals("done", response.getMessage());
  }
}