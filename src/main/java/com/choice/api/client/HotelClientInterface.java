package com.choice.api.client;

import com.choice.api.gen.CreateHotelResponse;
import com.choice.api.gen.DeleteHotelResponse;
import com.choice.api.gen.GetHotelResponse;
import com.choice.api.gen.GetListResponse;
import com.choice.api.gen.Hotel;
import com.choice.api.gen.UpdateHotelResponse;

public interface HotelClientInterface {

  GetHotelResponse get(int id);

  GetListResponse getList(int page, int size);

  CreateHotelResponse add(Hotel hotel);

  UpdateHotelResponse update(Hotel hotel);

  DeleteHotelResponse delete(int id);
}
