package com.mitemitreski.blog.spring.rest.http.patch.mvc;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Component
public class RestExceptionHandlers {

  @ExceptionHandler(RuntimeException.class)
  @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
  public void whenNotFound() {
  }

}
