package com.huang.accounting.frag_record;

import android.inputmethodservice.KeyboardView;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.huang.accounting.R;
import com.huang.accounting.db.AccountBean;
import com.huang.accounting.utils.KeyBoardUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public abstract class BaseRecordFragment extends Fragment {

    KeyboardView keyboardView;
    EditText et_money;
    ImageView iv_icon;
    GridView gridView;
    TextView typeTv, noteTv, timeTv;

    AccountBean accountBean;

    /* 让子类一定要重写这个方法*/
    public abstract void saveAccountToDB();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //将需要插入到记账本当中的数据保存成对象的形式
        accountBean = new AccountBean();
        accountBean.setTypename("其他");
        accountBean.setsImageId(R.mipmap.ic_qita_fs);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_outcome, container, false);
        initView(view);
        setInitTime();
        //给GridView填充数据的方法
        loadDataToGV();
    }

    private void loadDataToGV() {
        typeList = new ArrayList<>();
        adapter = new TypeBaseAdapter(getContext(), typeList);
        typeGv.setAdapter(adapter);
    }

    /* 获取当前时间，显示在timeTv上*/
    private void setInitTime() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        String time = sdf.format(date);
        timeTv.setText(time);
        accountBean.setTime(time);

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        accountBean.setYear(year);
        accountBean.setMonth(month);
        accountBean.setDay(day);
    }

    private void initView(View view) {
        keyboardView = view.findViewById(R.id.frag_record_keyboard);
        et_money = view.findViewById(R.id.fragment_record_money);
        iv_icon = view.findViewById(R.id.fragment_record_icon);
        gridView = view.findViewById(R.id.fragment_record_gridView);
        timeTv = view.findViewById(R.id.frag_record_tv_time);
        noteTv = view.findViewById(R.id.frag_record_tv_beizhu);
        typeTv = view.findViewById(R.id.fragment_record_type);
        // 让自定义软键盘显示出来
        KeyBoardUtils keyBoardUtils = new KeyBoardUtils(keyboardView, et_money);
        keyBoardUtils.showKeyboard();
        //设置接口，监听确定按钮按钮被点击了
        keyBoardUtils.setOnEnsureListener(() -> {
            //获取输入钱数
            String moneyStr = et_money.getText().toString();
            if (TextUtils.isEmpty(moneyStr) || moneyStr.equals("0")) {
                requireActivity().finish();
                return;
            }
            float money = Float.parseFloat(moneyStr);
            accountBean.setMoney(money);
            //获取记录的信息，保存在数据库当中
            saveAccountToDB();
            // 返回上一级页面
            requireActivity().finish();
        });
    }
}
