package com.ellamfar.moneytransferapplication;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Account {

  private @Id @GeneratedValue Long id;
  private String firstName;
  private String lastName;
  private double balance;

  Account() {}

  Account(String firstName, String lastName, double balance) {

    this.firstName = firstName;
    this.lastName = lastName;
    this.balance = balance;
  }

  public Long getId() {
    return this.id;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public double getBalance() {
    return balance;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public boolean withdraw(double amount) {
    if (amount <= this.balance) {
      this.balance -= amount;
      return true;
    }
    return false;
  }

  public void deposit(double amount) {
    this.balance += amount;
  }

  @Override
  public String toString() {
      return "Account{" +
              "id=" + this.id +
              ", firstName='" + this.firstName + '\'' +
              ", lastName='" + this.lastName + '\'' +
              ", balance=" + this.balance +
              '}';
  }

  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof Account))
      return false;
    Account account = (Account) o;
    return Objects.equals(this.id, account.id) && Objects.equals(this.firstName, account.firstName)
        && Objects.equals(this.lastName, account.lastName) && Double.compare(this.balance, account.balance) == 0;
  }

  @Override
  public int hashCode() {
      return Objects.hash(this.id, this.firstName, this.lastName, this.balance);
  }

}