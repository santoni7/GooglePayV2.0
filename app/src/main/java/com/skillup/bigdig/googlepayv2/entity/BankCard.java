package com.skillup.bigdig.googlepayv2.entity;

public class BankCard {
  private String ownerName;
  private String cardNumber;
  private float amount;
  private String date;
  private int pin;

  public BankCard(String ownerName, String cardNumber, String date){
    this.ownerName = ownerName;
    this.cardNumber = cardNumber;
    amount = 100f;
    this.date = date;
    pin = 1101;
  }

  public String getOwnerName() {
    return ownerName;
  }

  public void setOwnerName(String ownerName) {
    this.ownerName = ownerName;
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  public float getAmount() {
    return amount;
  }

  public void setAmount(float amount) {
    this.amount = amount;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public int getPin() {
    return pin;
  }

  public void setPin(int pin) {
    this.pin = pin;
  }
}
