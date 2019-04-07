package com.skillup.bigdig.googlepayv2.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.skillup.bigdig.googlepayv2.R;
import com.skillup.bigdig.googlepayv2.manager.BankCardManager;

public class BankCardActivity extends AppCompatActivity implements BankCardAdapter.IDetailCardListener {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_bank_card);
    BankCardManager.initBankCardLis();
    openBankCardFragment();
  }

  private void openBankCardFragment(){
    getSupportFragmentManager()
        .beginTransaction()
        .replace(R.id.holder_fragments, BankCardFragment.newInstance(this))
        .commit();
  }

  @Override
  public void openDetailCardFragment(int i){
    getSupportFragmentManager()
        .beginTransaction()
        .replace(R.id.holder_fragments, DetailCardFragment.newInstance(i))
        .addToBackStack(null)
        .commit();
  }
}
