package com.choice.api.domain;

import java.util.ArrayList;
import java.util.List;


public class Hotel {

  protected int id;
  protected String name;
  protected String address;
  protected int rating;
  protected List<Amenity> amenities;

  public int getId() {
    return id;
  }

  public void setId(int value) {
    this.id = value;
  }

  public String getName() {
    return name;
  }


  public void setName(String value) {
    this.name = value;
  }


  public String getAddress() {
    return address;
  }

  public void setAddress(String value) {
    this.address = value;
  }

  public int getRating() {
    return rating;
  }

  public void setRating(int value) {
    this.rating = value;
  }

  public List<Amenity> getAmenities() {
    if (amenities == null) {
      amenities = new ArrayList<Amenity>();
    }
    return this.amenities;
  }

}

