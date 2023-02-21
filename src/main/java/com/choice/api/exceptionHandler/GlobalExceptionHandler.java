package com.choice.api.exceptionHandler;

import java.net.ConnectException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.ws.soap.client.SoapFaultClientException;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler({SoapFaultClientException.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ApiError soapFaultClientException(SoapFaultClientException ex) {

    int code = 1000;
    return new ApiError(code, ex.getMessage());
  }

  @ExceptionHandler({ConnectException.class})
  @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
  public ApiError connectException(ConnectException ex) {

    int code = 2000;
    String message = "Something was wrong, Try again in some minutes";
    return new ApiError(code, message);
  }
}
