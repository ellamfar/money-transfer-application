package com.ellamfar.moneytransferapplication;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class InsufficientFundsAdvice {

  @ResponseBody
  @ExceptionHandler(InsufficientFundsException.class)
  String insufficientFundsHandler(InsufficientFundsException ex) {
    return ex.getMessage();
  }
}