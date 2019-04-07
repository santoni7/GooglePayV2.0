package com.skillup.bigdig.googlepayv2.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.skillup.bigdig.googlepayv2.R;

public class BankCardFragment extends Fragment {

  private BankCardAdapter.IDetailCardListener listener;

  public static BankCardFragment newInstance(BankCardAdapter.IDetailCardListener listener) {
    BankCardFragment fragment = new BankCardFragment();
    fragment.setListener(listener);
    return fragment;
  }

  RecyclerView rvBankCards;
  Button btAddCard;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.fragment_bank_card, container, false);
    rvBankCards = v.findViewById(R.id.rv_bank_cards);
    rvBankCards.setAdapter(new BankCardAdapter(listener));

    rvBankCards.setLayoutManager(new LinearLayoutManager(getContext()));

    btAddCard = v.findViewById(R.id.bt_add_card);
    btAddCard.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent addBankCardIntent = new Intent(getContext(), AddBankCardActivity.class);
        startActivity(addBankCardIntent);
      }
    });
    return v;
  }

  @Override
  public void onResume() {
    super.onResume();
    RecyclerView.Adapter currentAdapter = rvBankCards.getAdapter();
    if(currentAdapter!=null)
      currentAdapter.notifyDataSetChanged();
  }

  public void setListener(BankCardAdapter.IDetailCardListener listener) {
    this.listener = listener;
  }
}
