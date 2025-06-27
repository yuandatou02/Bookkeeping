package com.huang.accounting.frag_record;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.huang.accounting.R;
import com.huang.accounting.db.AccountBean;

public class BaseRecordFragment extends Fragment {

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
        initView();
    }

    private void initView() {
        
    }
}
