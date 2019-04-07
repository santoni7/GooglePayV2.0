package com.skillup.bigdig.googlepayv2.manager;

import com.skillup.bigdig.googlepayv2.entity.BankCard;

import java.util.ArrayList;
import java.util.List;

public class BankCardManager {

  public static final String ARG_CARD_ID = "arg card id";

  private static List<BankCard> bankCardList = new ArrayList<>();

  public static List<BankCard> getBankCardList() {
    return bankCardList;
  }

  public static void initBankCardLis(){
    bankCardList.add(new BankCard("Danya", "1234567890121477", "01.04.2021"));
    bankCardList.add(new BankCard("Sashsa", "1256789012341477", "01.04.2021"));
    bankCardList.add(new BankCard("Lesha", "4561237821477901", "01.04.2021"));
    bankCardList.add(new BankCard("Katya", "1221467890134577", "01.04.2021"));
    bankCardList.add(new BankCard("Jenya", "0134567778921214", "01.04.2021"));
    bankCardList.add(new BankCard("Kseniya", "9011456782123477", "01.04.2021"));
    bankCardList.add(new BankCard("Anonym", "3451262147890177", "01.04.2021"));
    bankCardList.add(new BankCard("OlegButz", "2141256789017734", "01.04.2021"));
    bankCardList.add(new BankCard("Kostya", "9017126787214345", "01.04.2021"));
  }
}
