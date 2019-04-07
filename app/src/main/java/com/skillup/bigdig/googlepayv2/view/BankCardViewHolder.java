package com.skillup.bigdig.googlepayv2.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.skillup.bigdig.googlepayv2.R;
import com.skillup.bigdig.googlepayv2.entity.BankCard;

public class BankCardViewHolder extends RecyclerView.ViewHolder {

  TextView tvOwnerName;
  TextView tvCardNum;
  TextView tvAmount;

  public BankCardViewHolder(@NonNull View itemView) {
    super(itemView);
    tvOwnerName = itemView.findViewById(R.id.tv_name);
    tvCardNum = itemView.findViewById(R.id.tv_card_num);
    tvAmount = itemView.findViewById(R.id.tv_amount);
  }

  public void bind(BankCard bankCardItem){
    tvOwnerName.setText(bankCardItem.getOwnerName());
    tvCardNum.setText(bankCardItem.getCardNumber());
    tvAmount.setText(String.valueOf(bankCardItem.getAmount()));
  }
}
