package com.skillup.bigdig.googlepayv2.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.skillup.bigdig.googlepayv2.R;
import com.skillup.bigdig.googlepayv2.entity.BankCard;
import com.skillup.bigdig.googlepayv2.manager.BankCardManager;

public class AddBankCardActivity extends AppCompatActivity {

  EditText etOwnerName;
  EditText etCardNum;
  EditText etDate;

  Button btSaveCard;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_bank_card);
    etOwnerName = findViewById(R.id.et_owner_name);
    etCardNum = findViewById(R.id.et_card_number);
    etDate = findViewById(R.id.et_date);
    btSaveCard = findViewById(R.id.bt_save_card);
    btSaveCard.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String ownerName = etOwnerName.getText().toString();
        String cardNum = etCardNum.getText().toString();
        String date = etDate.getText().toString();
        BankCard newBankCard = new BankCard(ownerName, cardNum, date);
        BankCardManager.getBankCardList().add(newBankCard);
        finish();
      }
    });
  }
}
