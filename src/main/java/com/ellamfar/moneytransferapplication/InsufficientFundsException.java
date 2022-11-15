package com.ellamfar.moneytransferapplication;

public class InsufficientFundsException extends RuntimeException {
    InsufficientFundsException() {
      super("Insufficient funds.");
    }
}
