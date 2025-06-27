package com.huang.accounting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    ListView mainItems;
    ImageView mainSearch;
    Button mainEdit;
    ImageButton mainMore;
    // 头布局相关控件
    View mainTop;
    TextView mouthOutNum, mouthInNum, budgetNum, topDay;
    ImageView isHide;
    Integer year, month, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTime();
        initView();
        // 添加listview头布局
        addMainItemHeader();
    }

    /**
     * 给ListView添加头布局的方法
     */
    private void addMainItemHeader() {
        // 将布局转化为View对象
        mainTop = getLayoutInflater().inflate(R.layout.main_item_top, null);
        // 将头布局添加到ListView中
        mainItems.addHeaderView(mainTop);
        // 获取头布局中的各个组件
        mouthOutNum = findViewById(R.id.main_item_top_mouth_out_num);
        mouthInNum = findViewById(R.id.main_item_top_mouth_in_num);
        budgetNum = findViewById(R.id.main_item_top_mouth_budget_num);
        topDay = findViewById(R.id.main_item_top_day);
        isHide = findViewById(R.id.main_item_top_hide);
    }


    /**
     * 初始化视图组件
     * <p>
     * 在此方法中，通过 findViewById 方法从布局文件中获取相应的视图组件实例
     * 这些视图组件包括主项目列表、搜索图标、编辑按钮和更多按钮
     * 通过在初始化阶段获取这些组件的引用，可以在后续的操作中方便地对它们进行操作
     */
    private void initView() {
        // 获取主项目列表视图的引用
        mainItems = findViewById(R.id.main_item);
        // 获取搜索图标视图的引用
        mainSearch = findViewById(R.id.main_top_ic_search);
        // 获取编辑按钮的引用并绑定点击事件
        findViewById(R.id.main_btn_edit).setOnClickListener(v -> {
            Intent intent = new Intent(this, RecordActivity.class);
            startActivity(intent);
        });
        // 获取更多按钮视图的引用
        mainMore = findViewById(R.id.main_btn_more);
    }

    /**
     * 初始化当前日期
     * 此方法用于获取当前的年、月、日，并将其赋值给相应的变量
     * 它通过Calendar类来获取当前系统日期，并分解为年、月、日部分
     * 注意：月份获取后需要加1，因为Calendar类中月份的取值范围是0-11
     */
    private void initTime() {
        // 获取当前系统日期和时间
        Calendar calendar = Calendar.getInstance();
        // 提取年份
        year = calendar.get(Calendar.YEAR);
        // 提取月份并加1，因为Calendar月份从0开始
        month = calendar.get(Calendar.MONTH) + 1;
        // 提取日期
        day = calendar.get(Calendar.DAY_OF_MONTH);
    }
}