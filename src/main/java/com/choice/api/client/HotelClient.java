package com.choice.api.client;

import com.choice.api.gen.CreateHotelRequest;
import com.choice.api.gen.CreateHotelResponse;
import com.choice.api.gen.DeleteHotelRequest;
import com.choice.api.gen.DeleteHotelResponse;
import com.choice.api.gen.GetHotelRequest;
import com.choice.api.gen.GetHotelResponse;
import com.choice.api.gen.GetListRequest;
import com.choice.api.gen.GetListResponse;
import com.choice.api.gen.Hotel;
import com.choice.api.gen.SearchByNameRequest;
import com.choice.api.gen.SearchByNameResponse;
import com.choice.api.gen.UpdateHotelRequest;
import com.choice.api.gen.UpdateHotelResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class HotelClient extends WebServiceGatewaySupport implements HotelClientInterface {

  public GetHotelResponse get(int id) {
    GetHotelRequest request = new GetHotelRequest();
    request.setId(id);

    return (GetHotelResponse) getWebServiceTemplate()
        .marshalSendAndReceive(request);
  }

  public GetListResponse getList(int page, int size) {
    GetListRequest request = new GetListRequest();
    request.setPage(page);
    request.setSize(size);

    return (GetListResponse) getWebServiceTemplate()
        .marshalSendAndReceive(request);
  }

  public CreateHotelResponse add(Hotel hotel) {
    CreateHotelRequest request = new CreateHotelRequest();
    request.setAddress(hotel.getAddress());
    request.setName(hotel.getName());
    request.setRating(hotel.getRating());
    request.getAmenities().addAll(hotel.getAmenities());

    return (CreateHotelResponse) getWebServiceTemplate()
        .marshalSendAndReceive(request);
  }

  public UpdateHotelResponse update(Hotel hotel) {
    UpdateHotelRequest request = new UpdateHotelRequest();
    request.setHotel(hotel);

    return (UpdateHotelResponse) getWebServiceTemplate()
        .marshalSendAndReceive(request);
  }

  public DeleteHotelResponse delete(int id) {
    DeleteHotelRequest request = new DeleteHotelRequest();
    request.setId(id);

    return (DeleteHotelResponse) getWebServiceTemplate()
        .marshalSendAndReceive(request);
  }

  public SearchByNameResponse search(String search, int page, int size) {
    SearchByNameRequest request = new SearchByNameRequest();
    request.setName(search);
    request.setPage(page);
    request.setSize(size);

    return (SearchByNameResponse) getWebServiceTemplate()
        .marshalSendAndReceive(request);
  }
}
