package com.ellamfar.moneytransferapplication;

import java.util.Objects;

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

//   public void transfer() {
//         this.accountFrom.setBalance(this.accountFrom.getBalance() - this.amount);
//         this.accountTo.setBalance(this.accountTo.getBalance() + this.amount);
//     }

//   @Override
//   public String toString() {
//       return "TransferRequest{" +
//               "accountFromID=" + this.accountFromID +
//               ", accountToID=" + this.accountToID +
//               ", amount=" + this.amount +
//               '}';
//   }

//   @Override
//   public boolean equals(Object o) {

//     if (this == o)
//       return true;
//     if (!(o instanceof TransferRequest))
//       return false;
//     TransferRequest transferRequest = (TransferRequest) o;
//     return Objects.equals(this.accountFromID, transferRequest.accountFromID) && Objects.equals(this.accountToID, transferRequest.accountToID)
//         && Objects.equals(this.amount, transferRequest.amount);
//   }

//   @Override
//   public int hashCode() {
//       return Objects.hash(this.accountFromID, this.accountToID, this.amount);
//   }

}