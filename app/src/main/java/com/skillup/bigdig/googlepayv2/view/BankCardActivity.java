package com.skillup.bigdig.googlepayv2.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.skillup.bigdig.googlepayv2.R;
import com.skillup.bigdig.googlepayv2.manager.BankCardManager;

public class BankCardActivity extends AppCompatActivity implements BankCardAdapter.IDetailCardListener {

  private boolean isTwoPan = false;
  private BankCardFragment bankCardFragment;
  private DetailCardFragment detailCardFragment;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_bank_card);

    View detailLayout = findViewById(R.id.holder_details);
    isTwoPan = detailLayout != null;

    bankCardFragment = BankCardFragment.newInstance(this);
    detailCardFragment = DetailCardFragment.newInstance(0);

    BankCardManager.initBankCardLis();

    showFragments();
  }

  private void showFragments(){
    if(isTwoPan){
      getSupportFragmentManager()
              .beginTransaction()
              .replace(R.id.holder_fragments, bankCardFragment)
              .replace(R.id.holder_details, detailCardFragment)
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
    if(isTwoPan){
      getSupportFragmentManager()
              .beginTransaction()
              .replace(R.id.holder_details, DetailCardFragment.newInstance(i))
              .addToBackStack(null)
              .commit();
    } else {
      getSupportFragmentManager()
              .beginTransaction()
              .replace(R.id.holder_fragments, DetailCardFragment.newInstance(i))
              .addToBackStack(null)
              .commit();
    }
  }
}
