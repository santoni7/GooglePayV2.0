package com.skillup.bigdig.googlepayv2.view;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class DetailFragmentAdapter extends FragmentStatePagerAdapter{
  public DetailFragmentAdapter(FragmentManager fm) {
    super(fm);
  }

  @Override
  public Fragment getItem(int i) {
    switch (i){
        case 0:
          return DetailCardFragment.newInstance(0);
        case 1:
          return DetailCardEditFragment.newInstance(0);
        default:
      throw new RuntimeException("wrong id");
    }
  }

  @Override
  public int getCount() {
    return 2;
  }

  @Nullable
  @Override
  public CharSequence getPageTitle(int position) {
    switch (position){
      case 0:
        return "Информация";
      case 1:
        return "Изменить";
      default:
        throw new RuntimeException("wrong id");
    }
  }
}
