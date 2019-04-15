package com.skillup.bigdig.googlepayv2.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.skillup.bigdig.googlepayv2.R;
import com.skillup.bigdig.googlepayv2.entity.BankCard;
import com.skillup.bigdig.googlepayv2.manager.BankCardManager;

public class DetailCardFragment extends Fragment {

  public static DetailCardFragment newInstance(int i) {
    Bundle args = new Bundle();
    args.putInt(BankCardManager.ARG_CARD_ID, i);
    DetailCardFragment fragment = new DetailCardFragment();
    fragment.setArguments(args);
    return fragment;
  }

  TextView tvOwnerName;
  TextView tvCardNum;
  TextView tvAmount;
  TextView tvDate;
  TextView tvPin;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.fragment_detail_card, container, false);
    initViews(v);
    return v;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    fillViews();
  }

  private void initViews(View v) {
    tvOwnerName = v.findViewById(R.id.tv_owner_name);
    tvCardNum = v.findViewById(R.id.tv_card_num);
    tvAmount = v.findViewById(R.id.tv_amount);
    tvDate = v.findViewById(R.id.tv_date);
    tvPin = v.findViewById(R.id.tv_pin);
  }

  private void fillViews() {
    int i = getArguments().getInt(BankCardManager.ARG_CARD_ID, -1);
    if (i < 0)
      throw new RuntimeException("wrong card id");
    BankCard bankCard = BankCardManager.getBankCardList().get(i);
    tvOwnerName.setText(bankCard.getOwnerName());
    tvCardNum.setText(bankCard.getCardNumber());
    tvAmount.setText(String.valueOf(bankCard.getAmount()));
    tvDate.setText(bankCard.getDate());
    tvPin.setText(String.valueOf(bankCard.getPin()));
  }

  public void update() {
    if (BankCardManager.wasChanged()) {
      fillViews();
    }
  }
}
