package com.skillup.bigdig.googlepayv2.manager;

import android.content.Context;

import com.skillup.bigdig.googlepayv2.entity.BankCard;
import com.skillup.bigdig.googlepayv2.room.AppDatabaseProvider;

import java.util.ArrayList;
import java.util.List;

public class BankCardManager {

  public static final String ARG_CARD_ID = "arg card id";

  private static List<BankCard> bankCardList = new ArrayList<>();

  private static boolean wasChanged = false;

  public static List<BankCard> getBankCardList() {
    return bankCardList;
  }

  public static void initBankCardList(Context context){
    bankCardList.addAll(AppDatabaseProvider.getInstance(context).getBankCardDao().getAll());
    setChanged(true);
  }

  public static boolean wasChanged() {
    return wasChanged;
  }

  public static void setChanged(boolean wasChanged) {
    BankCardManager.wasChanged = wasChanged;
  }

  public static void addToList(BankCard bankCard, Context context){
    bankCardList.add(bankCard);
    AppDatabaseProvider.getInstance(context)
            .getBankCardDao().insert(bankCard);
  }

  public static void updateBankCard(int id, Context context){
    AppDatabaseProvider.getInstance(context)
            .getBankCardDao().update(bankCardList.get(id));
  }
}
