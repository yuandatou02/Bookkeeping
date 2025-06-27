package com.huang.accounting.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class RecordPagerAdapter extends FragmentStateAdapter {
    List<Fragment> fragmentList;
    String[] titles = {"支出", "收入"};

    public RecordPagerAdapter(@NonNull FragmentActivity fragmentActivity, List<Fragment> fragmentList) {
        super(fragmentActivity);
        this.fragmentList = fragmentList;
    }

    // 可选：获取标题
    public String getPageTitle(int position) {
        return titles[position];
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getItemCount() {
        return fragmentList.size();
    }
}
