package com.ellamfar.moneytransferapplication;

// Create Transfer Request Class
class TransferRequest {

  // Initialize variables: ID of Account Sending, ID of Account Receiving, Amount Transferred
  private Long accountFromID;
  private Long accountToID;
  private double amount;

  // Constructors
  TransferRequest() {}

  TransferRequest(Long accountFromID, Long accountToID, double amount) {

    this.accountFromID = accountFromID;
    this.accountToID = accountToID;
    this.amount = amount;
  }

  // Getters
  public Long getAccountFromID() {
    return this.accountFromID;
  }

  public Long getAccountToID() {
    return this.accountToID;
  }

  public double getAmount() {
    return amount;
  }

  // Setters
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