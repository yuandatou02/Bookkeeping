package com.huang.accounting;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.huang.accounting.adapter.RecordPagerAdapter;
import com.huang.accounting.frag_record.BaseRecordFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;


public class RecordActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        // 获取TabLayout和ViewPager
        tabLayout = findViewById(R.id.record_tables);
        viewPager = findViewById(R.id.record_view_pager);
        // 设置ViewPager加载页面
        initPagers();
        // 绑定关闭事件
        findViewById(R.id.record_back).setOnClickListener(v -> finish());
    }

    private void initPagers() {
        // 初始化ViewPager页面的集合
        List<Fragment> fragmentList = new ArrayList<>();
        // 创建收入和支出页面，放置在Fragment当中
        BaseRecordFragment incomeFragment = new BaseRecordFragment();
        fragmentList.add(incomeFragment);
        // 创建适配器
        RecordPagerAdapter adapter = new RecordPagerAdapter(this, fragmentList);
        // 设置适配器
        viewPager.setAdapter(adapter);
        //将TabLayout和ViewPager进行关联
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            tab.setText(adapter.getPageTitle(position));
        }).attach();
    }
}