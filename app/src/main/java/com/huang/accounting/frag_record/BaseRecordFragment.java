package com.huang.accounting.frag_record;

import android.inputmethodservice.KeyboardView;
import android.os.Bundle;
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

public class BaseRecordFragment extends Fragment {

    KeyboardView keyboardView;
    EditText et_money;
    ImageView iv_icon;
    GridView gridView;
    TextView type, note, time;

    AccountBean accountBean;

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

    }

    private void initView(View view) {
        keyboardView = view.findViewById(R.id.frag_record_keyboard);
        et_money = view.findViewById(R.id.fragment_record_money);
        iv_icon = view.findViewById(R.id.fragment_record_icon);
        gridView = view.findViewById(R.id.fragment_record_gridView);
        time = view.findViewById(R.id.frag_record_tv_time);
        note = view.findViewById(R.id.frag_record_tv_beizhu);
        type = view.findViewById(R.id.fragment_record_type);
    }
}
