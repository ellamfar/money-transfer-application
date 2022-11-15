package com.ellamfar.moneytransferapplication;

class TransferRequest {

  private Long accountFromID;
  private Long accountToID;
  private double amount;

  TransferRequest() {}

  TransferRequest(Long accountFromID, Long accountToID, double amount) {

    this.accountFromID = accountFromID;
    this.accountToID = accountToID;
    this.amount = amount;
  }

  public Long getAccountFromID() {
    return this.accountFromID;
  }

  public Long getAccountToID() {
    return this.accountToID;
  }

  public double getAmount() {
    return amount;
  }

  public void setAccountFromID(Long accountFromID) {
    this.accountFromID = accountFromID;
  }

  public void setAccountToID(Long accountToID) {
    this.accountToID = accountToID;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

}