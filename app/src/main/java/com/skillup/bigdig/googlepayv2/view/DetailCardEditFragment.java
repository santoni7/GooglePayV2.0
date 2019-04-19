package com.skillup.bigdig.googlepayv2.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.skillup.bigdig.googlepayv2.R;
import com.skillup.bigdig.googlepayv2.entity.BankCard;
import com.skillup.bigdig.googlepayv2.manager.BankCardManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailCardEditFragment extends Fragment {

  public interface ISaveListener{
    void saveClicked();
  }

  private ISaveListener listener;

  public void setListener(ISaveListener listener) {
    this.listener = listener;
  }

  public static DetailCardEditFragment newInstance(int i, ISaveListener listener) {
    Bundle args = new Bundle();
    args.putInt(BankCardManager.ARG_CARD_ID, i);
    DetailCardEditFragment fragment = new DetailCardEditFragment();
    fragment.setListener(listener);
    fragment.setArguments(args);
    return fragment;
  }

  @BindView(R.id.et_owner_name)
  EditText etOwnerName;
  @BindView(R.id.et_card_num)
  EditText etCardNum;
  @BindView(R.id.et_amount)
  EditText etAmount;
  @BindView(R.id.et_date)
  EditText etDate;
  @BindView(R.id.et_pin)
  EditText etPin;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.fragment_detail_card_edit, container, false);
    ButterKnife.bind(this, v);
    return v;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    int i = getArguments().getInt(BankCardManager.ARG_CARD_ID, -1);
    if(i<0)
      throw new RuntimeException("wrong card id");
    BankCard bankCard = BankCardManager.getBankCardList().get(i);
    fillViews(bankCard);
  }

  private void fillViews(BankCard bankCard){
    etOwnerName.setText(bankCard.getOwnerName());
    etCardNum.setText(bankCard.getCardNumber());
    etAmount.setText(String.valueOf(bankCard.getAmount()));
    etDate.setText(bankCard.getDate());
    etPin.setText(String.valueOf(bankCard.getPin()));
  }

  @OnClick(R.id.bt_save)
  void saveCard(){
    int i = getArguments().getInt(BankCardManager.ARG_CARD_ID, -1);
    BankCard bankCard = BankCardManager.getBankCardList().get(i);
    bankCard.setAmount(Float.valueOf(etAmount.getText().toString()));
    bankCard.setCardNumber(etCardNum.getText().toString());
    bankCard.setDate(etDate.getText().toString());
    bankCard.setOwnerName(etOwnerName.getText().toString());
    bankCard.setPin(Integer.valueOf(etPin.getText().toString()));
    BankCardManager.setChanged(true);
    BankCardManager.updateBankCard(i, getContext());
    listener.saveClicked();
  }
}
