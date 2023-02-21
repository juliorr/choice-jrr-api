package com.choice.api.exceptionHandler;

import java.sql.Timestamp;

public class ApiError {

  private int code;
  private String message;
  private Timestamp timestamp;

  public ApiError(int code, String message) {
    this.code = code;
    this.message = message;
    this.timestamp = new Timestamp(System.currentTimeMillis());
  }

  public ApiError(int code, String message, Timestamp timestamp) {
    this.code = code;
    this.message = message;
    this.timestamp = timestamp;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Timestamp getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Timestamp timestamp) {
    this.timestamp = timestamp;
  }
}
