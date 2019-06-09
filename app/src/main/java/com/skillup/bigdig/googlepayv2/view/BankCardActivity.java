package com.skillup.bigdig.googlepayv2.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.skillup.bigdig.googlepayv2.R;
import com.skillup.bigdig.googlepayv2.manager.BankCardManager;

public class BankCardActivity extends AppCompatActivity implements BankCardAdapter.IDetailCardListener {

  private boolean isTwoPan = false;
  private BankCardFragment bankCardFragment;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_bank_card);

    View detailLayout = findViewById(R.id.holder_details);
    isTwoPan = detailLayout != null;

    bankCardFragment = BankCardFragment.newInstance(this);

    BankCardManager.initBankCardLis();

    showFragments();
  }

  private void showFragments(){
    if(isTwoPan){
      getSupportFragmentManager()
              .beginTransaction()
              .replace(R.id.holder_fragments, bankCardFragment)
              .replace(R.id.holder_details, DetailCardFragment.newInstance(0))// переменная была не нужна для этого фрагмента
              .commit();
    } else {
      getSupportFragmentManager()
              .beginTransaction()
              .replace(R.id.holder_fragments, bankCardFragment)
              .commit();
    }
  }

  @Override
  public void openDetailCardFragment(int i){
    int containerId = R.id.holder_fragments;
    if(isTwoPan) containerId = R.id.holder_details;
    getSupportFragmentManager()
            .beginTransaction()
            .replace(containerId, DetailCardFragment.newInstance(i))
            .addToBackStack(null)
            .commit();
  }
}
