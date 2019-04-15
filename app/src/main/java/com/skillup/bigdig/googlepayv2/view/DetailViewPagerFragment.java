package com.skillup.bigdig.googlepayv2.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.skillup.bigdig.googlepayv2.R;
import com.skillup.bigdig.googlepayv2.manager.BankCardManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class DetailViewPagerFragment extends Fragment {

  public static DetailViewPagerFragment newInstance(int position) {

    Bundle args = new Bundle();
    args.putInt(BankCardManager.ARG_CARD_ID, position);
    DetailViewPagerFragment fragment = new DetailViewPagerFragment();
    fragment.setArguments(args);
    return fragment;
  }

  Unbinder unbinder;

  @BindView(R.id.vp_detail_fragments)
  ViewPager vpDetailFragments;

  @BindView(R.id.tl_detail_fragments)
  TabLayout tlDetailFragments;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.fragment_detail_viewpager, container, false);
    unbinder = ButterKnife.bind(this, v);
    return v;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    int position = getArguments().getInt(BankCardManager.ARG_CARD_ID, 0);
    vpDetailFragments.setAdapter(new DetailFragmentAdapter(getActivity().getSupportFragmentManager(), position));
    tlDetailFragments.setupWithViewPager(vpDetailFragments);
    vpDetailFragments.addOnPageChangeListener(pageChangeListener);
  }

  ViewPager.OnPageChangeListener pageChangeListener =
      new ViewPager.OnPageChangeListener() {
    @Override
    public void onPageScrolled(int i, float v, int i1) {
      ((DetailFragmentAdapter)vpDetailFragments.getAdapter()).updateData();
    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {
    }
  };

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    unbinder.unbind();
  }
}
