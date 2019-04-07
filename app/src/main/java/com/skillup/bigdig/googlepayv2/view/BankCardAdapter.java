package com.skillup.bigdig.googlepayv2.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.skillup.bigdig.googlepayv2.R;
import com.skillup.bigdig.googlepayv2.manager.BankCardManager;

public class BankCardAdapter extends RecyclerView.Adapter<BankCardViewHolder> {

  public interface IDetailCardListener{
    void openDetailCardFragment(int i);
  }

  private IDetailCardListener listener;

  public BankCardAdapter(IDetailCardListener listener){
    this.listener = listener;
  }

  @NonNull
  @Override
  public BankCardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    View view =
        LayoutInflater.from(viewGroup.getContext())
        .inflate(
            R.layout.list_item_bank_car,
            viewGroup,
            false);
    return new BankCardViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull BankCardViewHolder bankCardViewHolder, int i) {
    bankCardViewHolder.bind(BankCardManager.getBankCardList().get(i));
    final int id = i;
    bankCardViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if(listener==null)
          throw new RuntimeException("empty detail card listener");
        listener.openDetailCardFragment(id);
      }
    });
  }

  @Override
  public int getItemCount() {
    return BankCardManager.getBankCardList().size();
  }

}
