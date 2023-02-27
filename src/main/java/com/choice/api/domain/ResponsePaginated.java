package com.choice.api.domain;

import com.choice.api.gen.Hotel;
import java.util.ArrayList;
import java.util.List;

public class ResponsePaginated {

  protected int size;
  protected int page;
  protected int totalPages;
  protected int totalElements;
  protected List<Hotel> hotels;

  public int getSize() {
    return size;
  }

  public void setSize(int value) {
    this.size = value;
  }

  public int getPage() {
    return page;
  }

  public void setPage(int value) {
    this.page = value;
  }

  public int getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(int value) {
    this.totalPages = value;
  }

  public int getTotalElements() {
    return totalElements;
  }

  public void setTotalElements(int value) {
    this.totalElements = value;
  }

  public List<Hotel> getHotels() {
    if (hotels == null) {
      hotels = new ArrayList<Hotel>();
    }
    return this.hotels;
  }

}
